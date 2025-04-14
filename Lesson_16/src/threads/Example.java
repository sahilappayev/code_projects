package threads;

public class Example {


    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Producer producer1 = new Producer(sharedResource);
        Producer producer2 = new Producer(sharedResource);
        Producer producer3 = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        producer1.start();
        producer2.start();
        producer3.start();

        try {
            producer1.getThread().join();
            producer2.getThread().join();
            producer3.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumer.start();

        try {
            consumer.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
