package producer_consumer;

class Producer extends Thread {
    private final DateResource resource;

    public Producer(DateResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        // calculation
        //


        for (int i = 1; i <= 10; i++) {
            resource.produce(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
