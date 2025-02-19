package abstraction;

public class Developer extends Employee {

    private String language;

    public Developer(String name, int salary, String position) {
        super(name, salary, position);
        System.err.println("Created Developer");
    }

    public Developer(String name, int salary, String position, String language) {
        super(name, salary, position);
        this.language = language;
    }

    @Override
    public void doWork() {
        System.out.println("Developer is coding...");
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "language='" + language + '\'' +
                " " + super.toString() +
                '}';
    }
}
