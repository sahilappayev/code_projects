package abstraction;

public class Hr extends Employee {


    public Hr(String name, int salary, String position) {
        super(name, salary, position);
    }

    @Override
    public void doWork() {
        System.out.println("HR is hiring....");
    }
}
