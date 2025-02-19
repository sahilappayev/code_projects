package abstraction;

public abstract class Employee {

    private String name;
    private int salary;
    private String position;

    public Employee(String name, int salary, String position) {

        System.err.println("Created Employee");

        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public abstract void doWork();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }
}
