package threads;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // Process
        // Thread
        // Concurrency vs Parallelism
        //

        System.out.println(new Date());

//        Thread myThread = new Thread(() -> {
//            // Process
//
//            MyThread myThread1 = new MyThread("MyThread");
//            myThread1.start();
//
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Hello World From " + Thread.currentThread().getName());
//            System.out.println(new Date());
//        });

//        MyThread myThread = new MyThread();


//        Thread myThread = new Thread(new MyNewThread());

        MyNewThread myThread = new MyNewThread();

        myThread.getThread().start();

        System.out.println(new Date());

        System.out.println("currentThread: " + Thread.currentThread().getName());
        System.out.println("activeCount: " + Thread.activeCount());

        System.out.println("Hello World");

        System.out.println("Last:" + new Date());
    }

}
