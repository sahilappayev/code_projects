package oop_principles;

public class Main {


    public static void main(String[] args) {

        // OOP - object oriented programming
        // 1. Inheritance - varislik
        // 2. Encapsulation - kapsullama
        // 3. Polymorphism - chox shekillik
        // 4. Abstraction  - mucerredlik, umumileshdirme

        // variable - field/state
        // method - behaviour
        Human human = new Human();
        human.name = "Ali";
        human.age = 5;
        human.gender = "Male";


        human.printHumanProperties();

        System.out.println("================");


        Person person = new Person();
        person.name = "Jane";
        person.age = 18;
        person.gender = "Female";
        person.character = "Lazy";
        person.skills = new String[]{"Drawing", "Walking"};

        person.printPersonProperties();

        Student student = new Student();



    }

}
