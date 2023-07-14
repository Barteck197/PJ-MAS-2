public class Application {
    private String name;
    private String version;
    private Computer computer;

    // Konstruktor prywatny - tworzenie części odbywa się przez specjalną metodę
    private Application(String appName, String appVersion, Computer appComputer) {
        this.name = appName;
        this.version = appVersion;
        this.computer = appComputer;
    }

    // Metoda tworząca część ...
    public static Application CreateApplication(Computer computer, String name, String version) throws Exception{
        // ... wymaga wpierw sprawdzenia czy jest jakaś całość do której możemy ją przypisać
        if (computer == null){
            throw new Exception("Podany komputer nie istnieje");
        }

        // Utworzenie części
        Application app = new Application(name, version,computer);

        // Dodanie części do całości
        computer.addApplication(app);

        return app;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
