package abstraction;

public class Head extends Employee implements Manageable {

    public Head(String name, int salary, String position) {
        super(name, salary, position);
    }

    @Override
    public void doWork() {
        System.out.println("Head is working....");
    }

    @Override
    public void manage() {
        System.out.println("Head is managing....");
    }
}
