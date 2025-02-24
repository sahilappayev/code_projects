package enums;

public enum Color {

    RED("qirmizi"),
    BLUE("mavi"),
    GREEN("yashil"),
    YELLOW("sari"),
    ORANGE(""),
    PURPLE("benovsheyi");

    private final String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
