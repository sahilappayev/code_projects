package producer_consumer;

class DateResource {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) {
        while (hasData) {  // false
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;  //
        hasData = true;  //
        System.err.println("Produced: " + value);

        notify();
    }

    public synchronized int consume() {
        while (!hasData) {  //  false
            try {
                wait(); // gozleyir
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}

