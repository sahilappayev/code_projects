package threads;

public class SharedResource {

    private String data;


    public String getData() {
        String result = data;
        data = null;
        return result;
    }

    public void setData(String data) {
        this.data = data;
    }
}
