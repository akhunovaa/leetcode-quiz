package interview.concurrency;

public class H2O {

    private final Object lock = new Object();
    private int counter = 0;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        synchronized (lock) {
            while (counter == 2) {
                lock.wait();
            }
            releaseHydrogen.run();
            counter++;
            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        synchronized (lock) {
            while (counter != 2) {
                lock.wait();
            }
            releaseOxygen.run();
            counter = 0;
            lock.notifyAll();
        }

    }

}
