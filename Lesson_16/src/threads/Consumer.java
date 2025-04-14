package threads;

public class Consumer implements Runnable {

    private final Thread thread;
    private final SharedResource resource;

    public Consumer( SharedResource resource) {
        this.thread = new Thread(this);
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("DATA: " + resource.getData());
        }
    }

    public void start() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }
}
