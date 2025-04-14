package threads;

import java.util.Date;

public class MyNewThread implements Runnable {

    private final Thread thread;

    public MyNewThread() {
        this.thread = new Thread(this);
    }

    public MyNewThread(String name) {
        this.thread = new Thread(this, name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World From " + Thread.currentThread().getName());
        System.out.println(new Date());
    }


//    public void start() {
//        this.thread.start();
//    }

    public Thread getThread() {
        return thread;
    }
}
