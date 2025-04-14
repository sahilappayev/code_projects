package threads;

public class Increrementer implements Runnable {

    private final Thread thread;
    private final Counter counter;


    public Increrementer(Counter counter) {
        this.counter = counter;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

            // calll clu

           synchronized (counter) {
               counter.setCount(counter.getCount() + 1);
           }

//            counter.increment();

        }
    }

    public Thread getThread() {
        return thread;
    }
}
