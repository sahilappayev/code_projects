package threads;

import java.util.Date;

public class MyThread extends Thread {


    public MyThread(String name) {
        super(name);
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
}
