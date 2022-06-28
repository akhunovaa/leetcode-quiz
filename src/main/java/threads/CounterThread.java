package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread extends Thread {

    // declaring a count variable
    private int count;
    private static final Object lock = new Object();
    // declaring an atomic variable
//    private AtomicInteger count = new AtomicInteger();
//
//    public static void main(String[] args) throws InterruptedException {
    //Start time
//        long begin = System.currentTimeMillis();
//        execute();
    //End time
//        long end = System.currentTimeMillis();
//        long time = end - begin;
//        System.out.println("Elapsed Time: " + time + " milli seconds");
//    }


    public void run() {
        execute();
    }

    private synchronized void execute() {

        // calculating the count
        for (int i = 1; i <= 15; i++) {
            synchronized (lock) {
                //            count++;
                try {
                    Thread.sleep(i * 10);
                    count++;
                    // calling incrementAndGet() method
                    // on count variable
//                count.incrementAndGet();
                } catch (InterruptedException e) { // throwing an exception
                    System.out.println(e);
                }
            }
        }
    }


    // returning the count value
    public int getCount() {
        return this.count;
    }

    // returning the count value
//    public AtomicInteger getCount() { return count; }
}
