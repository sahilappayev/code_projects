package excutor_service;

import java.util.concurrent.atomic.AtomicInteger;

public class JobThread extends Thread {

    private final static AtomicInteger jobCounter = new AtomicInteger(0);


    @Override
    public void run() {
        int incremented = jobCounter.incrementAndGet();
        try {
            System.out.println("Running job thread..." + incremented);
            Thread.sleep(2000);
            System.out.println("Completed job thread..." + incremented);
        }catch (InterruptedException ignore){}
    }
}
