package producer_consumer;

public class Main {

    public static void main(String[] args) {
        DateResource dateResource = new DateResource();

        Producer producer = new Producer(dateResource);
        Producer producer2 = new Producer(dateResource);
        Consumer consumer = new Consumer(dateResource);
        Consumer consumer2 = new Consumer(dateResource);

        producer.start();
        producer2.start();
        consumer.start();
        consumer2.start();

    }

}
