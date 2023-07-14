import java.util.ArrayList;
import java.util.List;

public class Employee {
    // Lista kart należących do pracownika
    private List<KeyCard> keyCards;
    private String name;

    public Employee(String name) {
        keyCards = new ArrayList<>();
        this.name = name;
    }

    public void addKeyCard(KeyCard newKeyCard){
        if(!keyCards.contains(newKeyCard)){
            keyCards.add(newKeyCard);

            newKeyCard.setOwner(this);
        }
    }

    public void removeKeyCard(KeyCard oldCard){
        keyCards.remove(oldCard);
        oldCard.removeOwner();
    }

    public void listCards(){
        System.out.println("Pracownik: " + name);
        for (KeyCard c: keyCards) {
            System.out.println("- Nr karty: " + c.getSerialNumber());
        }
    }
}
