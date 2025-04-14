package threads;

public class RaceCandition {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());

        Counter counter = new Counter();

        Increrementer i1 =new Increrementer(counter);
        Increrementer i2 =new Increrementer(counter);
        Increrementer i3 =new Increrementer(counter);

        i1.getThread().start();
        i2.getThread().start();
        i3.getThread().start();

        try {
            i1.getThread().join();
            i2.getThread().join();
            i3.getThread().join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Count: " + counter.getCount());

        System.out.println(System.currentTimeMillis());

    }


    public static synchronized void increrement(Counter counter) {
        synchronized (counter) {
            System.out.println("Count " + counter.getCount());
        }
    }


}
