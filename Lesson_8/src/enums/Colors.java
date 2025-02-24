package enums;

public final class Colors {

    private final String name;
    private String surname;

    public Colors(String name) {
        this.name = name;
    }

    public static final Colors RED = new Colors("RED");
    public static final Colors YELLOW = new Colors("YELLOW");
    public static final Colors GREEN = new Colors("GREEN");
    public static final Colors BLUE = new Colors("BLUE");
    public static final Colors PURPLE = new Colors("PURPLE");


    @Override
    public String toString() {
        return name;
    }


    public String name() {
        return name;
    }
}
