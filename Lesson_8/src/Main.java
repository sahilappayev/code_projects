import enums.Color;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Color[] values = Color.values();

        Random rand = new Random();

        Color color = values[rand.nextInt(values.length)];

        switch (color) {
            case RED:
                System.out.println(Color.RED.getValue());
                break;
            case BLUE:
                System.out.println(Color.BLUE.getValue());
                break;
            case GREEN:
                System.out.println(Color.GREEN.getValue());
                break;
            case YELLOW:
                System.out.println(Color.YELLOW.getValue());
                break;
            default:
                System.out.println(color);
        }
    }


}
