package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

//    private volatile AtomicInteger count = new AtomicInteger(0);
    private volatile int count = 0;

    public int getCount() {
        return count;
//        return count.get();
    }

    public void  setCount(int count) {
        this.count = count;
//        this.count.set(count);
    }


//    public void increment() {
//        count.incrementAndGet();
//    }
}
