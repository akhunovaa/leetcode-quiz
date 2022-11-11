package interview.concurrency;

import java.util.concurrent.Semaphore;

public class Foo {

    private static final Semaphore semFirst = new Semaphore(1);
    private static final Semaphore semSecond = new Semaphore(0);
    private static final Semaphore semThird = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            semFirst.acquire();
        } catch (InterruptedException e) {
            System.out.println("Exception InterruptedException catched");
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            semSecond.acquire();
        } catch (InterruptedException e) {
            System.out.println("Exception InterruptedException catched");
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semThird.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            semThird.acquire();
        } catch (InterruptedException e) {
            System.out.println("Exception InterruptedException catched");
        }
        printThird.run();
        semFirst.release();

    }

}
