package abstraction;

public class TechLead extends Employee implements Manageable {

    public TechLead(String name, int salary, String position) {
        super(name, salary, position);
    }

    @Override
    public void doWork() {
        System.out.println("Tech Lead is working....");
    }

    @Override
    public void manage() {
        System.out.println("Tech Lead is managing....");
    }
}
