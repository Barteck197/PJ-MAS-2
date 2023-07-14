public class Player {
    private String firstName;
    private String lastName;
    private String nationality;
    private Team playerTeam;
    private int numberInTeam;

    public Player(String firstName, String lastName, String nationality, int numberInTeam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.numberInTeam = numberInTeam;
    }

    public void setTeam(Team newTeam){
        if (playerTeam == null){
            playerTeam = newTeam;
            newTeam.addPlayer(this);
        }
    }

    public int getNumberInTeam() {
        return numberInTeam;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", playerTeam=" + playerTeam.getName() +
                ", numberInTeam=" + numberInTeam +
                '}';
    }
}
