package polymorphism;

public class BikeGarage extends Garage {


    @Override
    public Bike getVehicle() {
        return new Bike();
    }
}
