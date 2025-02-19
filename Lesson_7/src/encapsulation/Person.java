package encapsulation;

public class Person extends Human {

    private int age;


    public void printPerson() {

        System.out.println("Name: " + super.getName() + " Age: " + age);

    }

    public void setAge(int age) {
        if (age < 0) {
            System.err.println("Age cannot be negative");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
