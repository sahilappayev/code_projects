package deadlock;

class Thread2 extends Thread {
    public void run() {
        synchronized (SharedResource.lock2) { //  2ci monitor doldu
            System.out.println("Thread2: lock2 alındı.");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (SharedResource.lock1) { //
                System.out.println("Thread2: lock1 alındı.");
            }
        }
    }
}
