package design_patterns.builder;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setColor("Red");

        System.out.println(car1);

        Car car2 = Car.builder()
                .color("Blue")
                .gearSpeed("150")
                .wheel("asdasas")
                .build();

        System.out.println(car2);
    }

}
