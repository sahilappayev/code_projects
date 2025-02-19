package polymorphism;

public class Vehicle extends Transport{

    private String color;
    private int maximumSpeed;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "color='" + color + '\'' +
                ", maximumSpeed=" + maximumSpeed +
                '}';
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public void printProperties() {
        String value = "Vehicle{" +
                "color='" + color + '\'' +
                ", maximumSpeed=" + maximumSpeed +
                '}';
        System.out.println(value);
    }

    public CharSequence returnAsString(){
        return this.toString();
    }


}
