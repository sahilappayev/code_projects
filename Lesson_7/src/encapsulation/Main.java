package encapsulation;

public class Main {


    public static void main(String[] args) {

        Person person = new Person();
        person.setName("Ali");
        person.setAge(20);

        person.printPerson();

        person.setName("");
        person.setAge(-2);

        person.printPerson();






    }



}
