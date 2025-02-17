public class Main {

    public static void main(String[] args) {

        //

//        Car.className = "BMW";
//        Car.classColor = "RED";
//
//        System.out.println("Car name: " + Car.className + ", color: " + Car.classColor);
//
//        Car.className = "Mercedes";
//
//        System.out.println("Car name: " + Car.className + ", color: " + Car.classColor);
//
//        // class = type
//        Car car1 = new Car();// unvani
//
//
//        car1.name = "BMW";
//
//
//        Car car2 = new Car();
//        car2.name = "Mercedes";
//
//
//        System.out.println("Car1: " + car1.name);
//        System.out.println("Car2: " + car2.name);
//        System.out.println("Car1: " + car1.name);
//
//        System.out.println("===================");
//
//
//        Car.classMethod();
//        Car.classMethod();
//
//        car1.printObjectName();
//        car2.printObjectName();
//
//        System.out.println("====================");
//        changeCarName(car1);
//
//
//
//
//        car1.printObjectName();
//        car2.printObjectName();
//
//
//
//        car1.printObjectName();


        Car car3 = new Car();
        car3.name = "Audi";
        car3.color = "Blue";

        Car car4 = new Car("BMW");
        car4.color = "Yellow";

        car3.printObjectProperties();
//        car4.printObjectProperties();

        changeCarName(car3);


        car3.printObjectProperties();

        changeCarName(car3, "Lada");

        car3.printObjectProperties();
    }


    public static void changeIntValue(int i) {
        System.out.println("inside method 1 i= " + i);
        i = 15;
        System.out.println("inside method 2 i= " + i);
    }

    // method overloading
    public static void changeCarName(Car car) {
        car.name = "Elantra";
    }

    public static void changeCarName(Car car, String name) {
        car.name = name;
    }


}
