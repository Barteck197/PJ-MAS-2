import java.time.LocalDate;

public class Order {
    private static int globalOrderId = 0;
    private int orderId;
    private LocalDate placedDate;
    private int quantity;
    private Client orderClient;
    private Product orderProduct;

    // Konstruktor domyślny - automatyczne tworzenie połączenia z obiektami typu Client i Product
    public Order(LocalDate placedDate, int quantity, Client orderClient, Product orderProduct) {
        this.orderId = ++globalOrderId;
        this.placedDate = placedDate;
        this.quantity = quantity;
        this.orderClient = orderClient;
        this.orderProduct = orderProduct;

        // Tworzymy połączenie zwrotne
        orderClient.addOrder(this);
        orderProduct.addToOrder(this);
    }

    // Alternatywny konstruktor (zamówienie bez produktu i bez klienta)
    public Order(LocalDate placedDate, int quantity) {
        this.orderId = ++globalOrderId;
        this.placedDate = placedDate;
        this.quantity = quantity;
    }

    public void setClient(Client newClient) {
        // Jeśli zamówienie ma przypisanego klienta ...
        if (orderClient != null){
            // ... i jest to inny klient niż "nowy" ...
            if(orderClient != newClient){
                // ... to usuwamy połączenie
                newClient.removeOrder(this);
            }
        }
        orderClient = newClient;
        newClient.addOrder(this);
    }

    public void removeClient(){
        orderClient = null;
    }

    public void setProduct(Product newProduct) {
        if (orderProduct != null){
            // ... i jest to inny klient niż "nowy" ...
            if(orderProduct != newProduct){
                // ... to usuwamy połączenie
                newProduct.removeOrder(this);
            }
        }
        orderProduct = newProduct;
        newProduct.addToOrder(this);
    }

    public void removeProduct(){
        orderClient = null;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", placedDate=" + placedDate.toString() +
                ", quantity=" + quantity +
                ", orderClientName=" + orderClient.getClientName() +
//                ", orderProductName=" + orderProduct.getProductName() +
                '}';
    }
}
