package polymorphism;

public class Bike extends Vehicle{

    private Integer size;


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public void printProperties(){
        System.out.println("Bike{" +
                "size='" + size + '\'' +
                " " + super.toString() +
                '}');
    }

}
