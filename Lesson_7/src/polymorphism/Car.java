package polymorphism;

public class Car extends Vehicle {

    private String engineType;

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineType='" + engineType + '\'' +
                " " + super.toString() +
                '}';
    }

    @Override
    public void printProperties(){
        System.out.println("Car{" +
                "engineType='" + engineType + '\'' +
                " " + super.toString() +
                '}');
    }

    @Override
    public String returnAsString(){
        return this.toString();
    }

}
