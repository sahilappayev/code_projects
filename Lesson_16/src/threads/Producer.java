package threads;

public class Producer implements Runnable {

    private final String data = "data";
    private final Thread thread;
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.thread = new Thread(this);
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.setData(data + i);
        }
    }

    public void start() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }
}
