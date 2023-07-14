import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private String name;
    private List<Application> apps;
    private static Set<Application> allApps = new HashSet<>();

    public Computer(String name) {
        this.name = name;
        apps = new ArrayList<>();
    }

    public void addApplication(Application newApp) throws Exception{
        if (!apps.contains(newApp)){
            // Sprawdzamy, czy aplikacja nie została już dodana do jakiegoś komputera
            if (allApps.contains(newApp)){
                throw new Exception("Ta aplikacja jest już zainstalowana na innym komputerze");
            }
            apps.add(newApp);
            allApps.add(newApp);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Computer{name='" + name + '\'' + ", apps=");
        for (Application app : apps){
            info.append(app.toString());
        }
        return info.toString();
    }
}
