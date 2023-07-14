import java.util.HashMap;
import java.util.Map;

public class Team {
    private String name;

    private Map<Integer, Player> teamPlayers;

    public Team(String name) {
        this.name = name;
        this.teamPlayers = new HashMap<>();
    }

    public void addPlayer(Player newPlayer){
        if(!teamPlayers.containsKey(newPlayer.getNumberInTeam())){
            teamPlayers.put(newPlayer.getNumberInTeam(), newPlayer);

            newPlayer.setTeam(this);
        }
    }

    public Player findPlayerInTeam(int playerNumber) throws Exception{
        if (!teamPlayers.containsKey(playerNumber)){
            throw new Exception("No player with suchi id");
        }

        return teamPlayers.get(playerNumber);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", teamPlayers=" + teamPlayers.entrySet() +
                '}';
    }
}
