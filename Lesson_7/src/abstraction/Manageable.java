package abstraction;

public interface Manageable {

    String companyName = "MyCompany";


    default void manage(){};

    // yalniz public intance konkret method yazmaq isteyiremse,  defult istifade edirik
    default void doSomething() {
        System.out.println("do something");
    }


}
