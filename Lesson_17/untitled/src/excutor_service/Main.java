package excutor_service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) {
        System.out.println(new Date());
        // SingleThreadPool
        // FixedThreadPool
        // CachedThreadPool
        // ScheduledThreadPool


//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // tek thread uzerinde ishleyir
//        ExecutorService executorService = Executors.newFixedThreadPool(3); // verdiyimiz max deyer qeder thread yaradir
//        ExecutorService executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                100, TimeUnit.MILLISECONDS, new SynchronousQueue<>());   // CachedThreadPool
//        ExecutorService executorService = Executors.newCachedThreadPool(); // mueyyen muddetlik idle time verib yaranan threadleri tekrar istifade uchun poolda saxlaya bilirik
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        JobThread jobThread = new JobThread();
//        JobThread jobThread2 = new JobThread();

        executorService.scheduleAtFixedRate(jobThread, 2, 2000, TimeUnit.MILLISECONDS);  // 2 job rasdainda konkret period
//        executorService.scheduleAtFixedRate(jobThread2, 2, 2, TimeUnit.SECONDS);  //
        executorService.scheduleWithFixedDelay(jobThread, 2, 1000, TimeUnit.MILLISECONDS);


//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        MyThread myThread3 = new MyThread();
//        MyThread myThread4 = new MyThread();
//        MyThread myThread5 = new MyThread();

//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//        myThread5.start();


        // main GC = 2 thread
//        executorService.submit(myThread1);
//        executorService.submit(myThread2);
//        executorService.submit(myThread3);
//
//        System.out.println("Active Caount: " + Thread.activeCount());
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ignore) {
//        }
//
//        executorService.submit(myThread4);
//        executorService.submit(myThread5);

//        executorService.shutdown();

//        System.out.println("Active Caount: " + Thread.activeCount());
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ignore) {
//        }
//
//        System.out.println("Active Caount: " + Thread.activeCount());

//        executorService.shutdown();


    }


}
