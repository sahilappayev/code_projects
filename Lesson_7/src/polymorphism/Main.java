package polymorphism;

public class Main {

    public static void main(String[] args) {


        Car car = new Car();
        car.setColor("Red");
        car.setEngineType("Doch");
        car.setMaximumSpeed(240);


        Vehicle vehicle = new Car();

        vehicle.setColor("Blue");
        vehicle.setMaximumSpeed(150);

        Vehicle vehicle2 = new Bike();
        vehicle2.setColor("red");
        vehicle2.setMaximumSpeed(30);

        printObjectProperties(vehicle);

        printObjectProperties(vehicle2);


//        vehicle.printProperties();


//        String string = vehicle.toString();
//
//        System.out.println(string);


    }


    public static void printObjectProperties(Vehicle vehicle) {
        vehicle.printProperties();
    }


}
