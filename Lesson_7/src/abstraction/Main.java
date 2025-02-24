package abstraction;

import java.io.Serializable;

public class Main {


    public static void main(String[] args) {

        Developer employee = new Developer("Ali", 1000, "Dev");

        printInstanceName(employee);



//        System.out.println(developer);


//        Employee employee = new Employee("Aga", 1500, "intern") {
//            @Override
//            public void doWork() {
//                System.out.println("Employee working....");
//            }
//        };

//        System.out.println(employee);

//        Manageable manageable = new Manageable() {
//            @Override
//            public void manage() {
//                System.out.println("Manageable managed");
//            }
//        };


    }


    public static void printInstanceName(Employee employee) {
        if (employee instanceof Developer) {
            System.out.println("Developer");
        } else if (employee instanceof Hr) {
            System.out.println("HR");
        } else if (employee instanceof Head) {
            System.out.println("Head");
        } else if (employee instanceof TechLead) {
            System.out.println("Tech Lead");
        }
    }


}
