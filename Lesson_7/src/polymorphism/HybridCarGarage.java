package polymorphism;

public class HybridCarGarage extends Garage {


    @Override
    public HybridCar getVehicle() {
        return new HybridCar();
    }
}
