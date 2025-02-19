package polymorphism;

public class CarGarage extends Garage {

    @Override
    public Car getVehicle() {
        return new Car();
    }
}
