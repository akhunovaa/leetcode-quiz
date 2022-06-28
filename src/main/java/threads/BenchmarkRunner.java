package threads;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 5, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class BenchmarkRunner {

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public void init() throws InterruptedException {
        // creating a thread object
        CounterThread counterThread = new CounterThread();

        Thread t0 = new Thread(counterThread, "t0");
        // starting thread t0
        t0.start();

        Thread t1 = new Thread(counterThread, "t1");
        // starting thread t1
        t1.start();

        Thread t2 = new Thread(counterThread, "t2");
        // starting thread t2
        t2.start();

        Thread t3 = new Thread(counterThread, "t3");
        // starting thread t3
        t3.start();


        Thread t4 = new Thread(counterThread, "t4");
        // starting thread t4
        t4.start();


        Thread t5 = new Thread(counterThread, "t5");
        // starting thread t5
        t5.start();


        Thread t6 = new Thread(counterThread, "t6");
        // starting thread t6
        t6.start();


        Thread t7 = new Thread(counterThread, "t7");
        // starting thread t7
        t7.start();


        Thread t8 = new Thread(counterThread, "t8");
        // starting thread t8
        t8.start();


        Thread t9 = new Thread(counterThread, "t9");
        // starting thread t9
        t9.start();


        // calling join method on threads
        t0.join();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();

        // displaying the count
        System.out.print("" + counterThread.getCount() + " | ");
    }
}
