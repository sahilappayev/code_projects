package deadlock;

class Thread1 extends Thread {

    public void run() {
        synchronized (SharedResource.lock1) { // 1ci manotior doldu
            System.out.println("Thread1: lock1 alındı.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            synchronized (SharedResource.lock2) { // 2ci dolacaq
                System.out.println("Thread1: lock2 alındı.");
            }
        }
    }
}
