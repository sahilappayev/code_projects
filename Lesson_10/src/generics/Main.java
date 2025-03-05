package generics;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Generic - compile time type safety
        Store<Integer, Student> integerStore = new Store<>();  // raw type
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            integerStore.addData(random.nextInt());
        }

        System.out.println(integerStore);

        System.out.println("======================");

        Store<Student, Integer> studentStore = new Store<>();

        String name = "Name";

        for (int i = 0; i < 5; i++) {
            studentStore.addData(new Student(name + i, random.nextInt(50)));
        }

        printStudentsName(studentStore);


        Store<Student, Float> studentStore1 = new Store<>();

        printStudentsName(studentStore1);


//        Student student = new Student();
//
//        System.out.println(student.getClazz(new Object()));

    }

    // ? - unbounded
    // ? extends Number - upper-bounded
    // ? super String -  lower-bounded
    public static void printStudentsName(Store<Student, ? extends Number> studentStore) {
        for (int i = 0; i < studentStore.getCurrentIndex(); i++) {
            Student student = studentStore.getData(i);
            System.out.println(student.getName());
        }
    }

}
