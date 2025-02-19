package encapsulation;

public class Human {

    private String name;

    public void setName(String name) {

        if (name == null || name.isEmpty()) {
            System.err.println("Human name cannot be null or empty");
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
