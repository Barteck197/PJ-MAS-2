public class KeyCard {
    private static int globalNumber = 0;
    private int serialNumber;
    // Właściciel karty
    private Employee owner;

    public KeyCard() {
        this.serialNumber = ++globalNumber;
    }

    public void setOwner(Employee newOwner){
        // Jeśli karta ma właściciela ...
        if (owner != null) {
            // ... i jest to inna osoba niż nowy właścicel ...
            if (owner != newOwner) {
                // ... to usuwamy połączenie
                owner.removeKeyCard(this);
            }
        }
        // Tworzymy (nowe) połączenie
        owner = newOwner;
        newOwner.addKeyCard(this);
    }

    public void removeOwner(){
        owner = null;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
