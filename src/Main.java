import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("* Asocjacja binarna:");
        // ================== asocjacja binarna ================== //
        // Przypadek biznesowy: Pracownik może posiadać wiele kluczy-kart
        // ale jedna karta może mieć w danym momencie tylko jednego właścicela
        Employee e1 = new Employee("Marek");
        Employee e2 = new Employee("Ania");
        Employee e3 = new Employee("Jan");

        KeyCard c1 = new KeyCard();
        KeyCard c2 = new KeyCard();
        KeyCard c3 = new KeyCard();

        // Powiązanie Pracownika z kartą
        // tutaj przykład wywołania metody na obiekcie klasy KeyCard
        c1.setOwner(e1);
        c2.setOwner(e1);
        c3.setOwner(e2);

        // Próba ustawienia nowego właściciela karty
        c1.setOwner(e3);

        // ... można też wywołać metodę na obiekcie Employee
        e3.addKeyCard(c2);

        e1.listCards();
        e2.listCards();
        e3.listCards();

        System.out.println("* Asocjacja z atrybutem:");
        // ================== asocjacja z atrybutem ================== //
        // Przypadek biznesowy: Klient składa zamówienie w sklepie
        // Relacja: Klient <-> Produkt wymaga stworzenia
        // dodatkowej klasy asocjacji: Zamówienie. Liczności: w relacji
        // klient <-> produkt = *-*
        Client client1 = new Client("Adrianna");
        Client client2 = new Client("Monika");
//        Client client3 = new Client("Krzysztof");

        Product product1 = new Product("Jabłko", 3.49f);
        Product product2 = new Product("Gruszka", 3.99f);
//        Product product3 = new Product("Banan", 2.49f);
//        Product product4 = new Product("Brzoskwinia", 5.49f);
//        Product product5 = new Product("Liczi", 8.79f);
//        Product product6 = new Product("Śliwka", 6.99f);

        // W momencie tworzenia zamówienia automatycznie tworzone jest
        // połączenie zwrotne z instancjami obiektów client i product
        Order order1 = new Order(LocalDate.of(2022, 12, 16), 5, client1, product1);

        System.out.println(client1.getClientName());
        System.out.println(product1.getProductName());
        System.out.println(order1);

        Order order2 = new Order(LocalDate.of(2022, 12, 14), 12);

        // Teoretycznie można przypisać zamówienie do klienta i produktu po utworzeniu
        // zamówienia w systemie, choć biznesowo nie ma to za bardzo sensu.
        // Technicznie jest to możliwe

        // Zarówno od strony klienta
        client2.addOrder(order2);

        // Jak i od strony zamówienia
        order2.setClient(client2);

        // W takim przypadku należy też pamiętać o przypisaniu produktu
        product2.addToOrder(order2);

        // albo
        order2.setProduct(product2);

        System.out.println(client2.getClientName());
        System.out.println(order2);

        System.out.println("* Asocjacja kwalifikowana:");
        // ================== asocjacja kwalifikowana ================== //
        // Przypadek biznesowy: W zespole gra wielu zawodników, każdy z nich
        // ma przypisany numer, który nosi na koszulce. Po tym numerze można
        // jednoznacznie zidentyfikować zawodnika w ramach zespołu
        Player p1 = new Player("London", "Donovan", "US", 8);
        Player p2 = new Player("Artur", "Boruc", "PL", 1);
        Player p3 = new Player("Sergio", "Aguero", "UR", 11);
        Player p4 = new Player("Andrij", "Deshchytsia", "BL", 76);

        Team t1 = new Team("FK Kovno");
        Team t2 = new Team("Atletic Alicante");

        p1.setTeam(t1);
        p2.setTeam(t2);
        p3.setTeam(t1);
        p4.setTeam(t2);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        // Szukamy gracza z numerem 1 w drużynie 2
        try {
            System.out.println(t2.findPlayerInTeam(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("* kompozycja");
        // ================== kompozycja ================== //
        // Przypadek biznesowy: Aplikacja zainstalowana na komputerze
        // nie może istnieć samodzielnie. W momencie usunięcia komputera
        // z bazy, aplikacja też jest usuwana
        Computer computer1 = new Computer("Stacja robocza anowak");
        Computer computer2 = new Computer("Serwer biurowy");
        try {
            // Tworzenie obiektu Application odbywa się poprzez specjalną metodę statyczną
            Application app1 = Application.CreateApplication(computer1, "Apache", "2.4");
            System.out.println(app1);
            // Próba przypisania aplikacji do innego komputera:
//            computer2.addApplication(app1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Taki zapis jest niepoprawny
//        Application a = new Application("SQL Server", "2019", computer2);
    }
}