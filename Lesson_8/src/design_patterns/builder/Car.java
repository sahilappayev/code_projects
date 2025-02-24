package design_patterns.builder;

public class Car {

    private String model;
    private String color;
    private String engine;
    private String gear;
    private String wheel;
    private String wheelSpeed;
    private String gearSpeed;

    public Car() {
    }

    public Car(String model,
               String color,
               String engine,
               String gear,
               String wheel,
               String wheelSpeed,
               String gearSpeed) {
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.gear = gear;
        this.wheel = wheel;
        this.wheelSpeed = wheelSpeed;
        this.gearSpeed = gearSpeed;
    }


    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getWheelSpeed() {
        return wheelSpeed;
    }

    public void setWheelSpeed(String wheelSpeed) {
        this.wheelSpeed = wheelSpeed;
    }

    public String getGearSpeed() {
        return gearSpeed;
    }

    public void setGearSpeed(String gearSpeed) {
        this.gearSpeed = gearSpeed;
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", gear='" + gear + '\'' +
                ", wheel='" + wheel + '\'' +
                ", wheelSpeed='" + wheelSpeed + '\'' +
                ", gearSpeed='" + gearSpeed + '\'' +
                '}';
    }



    public static class CarBuilder {

        private String model;
        private String color;
        private String engine;
        private String gear;
        private String wheel;
        private String wheelSpeed;
        private String gearSpeed;

        private CarBuilder() {

        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder gear(String gear) {
            this.gear = gear;
            return this;
        }

        public CarBuilder wheel(String wheel) {
            this.wheel = wheel;
            return this;
        }

        public CarBuilder wheelSpeed(String wheelSpeed) {
            this.wheelSpeed = wheelSpeed;
            return this;
        }

        public CarBuilder gearSpeed(String gearSpeed) {
            this.gearSpeed = gearSpeed;
            return this;
        }

        public Car build() {
            return new Car(this.model, this.color, this.engine, this.gear, this.wheel, this.wheelSpeed, this.gearSpeed);
        }

    }


}
