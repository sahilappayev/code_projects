package solid;

public class Square implements Shape {

    private int x;


    @Override
    public int getArea() {
        return x * x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}


