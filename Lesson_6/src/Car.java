public class Car {

    public static String className;  // // static or class variable
    public static String classColor;
    public String name;  // instance variable
    public String color;


    // Instance

    // Constructor method
    public Car() {
//        System.err.println("Car Constructor called");
    }


    public Car(String name) {
        this.name = name;  // indiki anda yaranan obyekti ishare edir
        this.color = "white";
    }

    public Car(String name, String color) {
        this.name = name;  // indiki anda yaranan obyekti ishare edir
        this.color = color;
    }


    // class method
    public static void classMethod(){
        System.out.println("Called Class method called, Class name = " + className + ", Class color = " + classColor);
    }

    // instance method
    public void printObjectProperties(){
        System.out.println("Called instance method called." +
                " Car name = " + this.name + ", Car color = " + this.color);
    }

    public void foo(){
        System.out.println("Called Foo called");
    }

}
