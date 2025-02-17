package oop_principles;

// is a relationship
// human is parent or super class
// person is child or sub class
public class Person extends Human {

    public String character;
//    public String name;
    public String[] skills;


    public void printPersonProperties() {
        System.out.println("Person name: " + super.name
                + "\nPerson character: " + this.character
                + "\n Person skills: " + this.printSkills()
                + "\nPerson age: " + super.age
                + "\nPerson gender: " + super.gender);
    }

    public String printSkills() {
        String s = "Skills: ";

        for (String skill : skills) {
            s += skill + ", ";
        }

        return s;
    }


}
