package interview.concurrency;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class FizzBuzz {

    private final int max;
    private int counter = 1;

    public FizzBuzz(int n) {
        this.max = n;
    }

    private synchronized void synchronizedPrint(final Runnable print, final IntPredicate predicate) throws InterruptedException {
        while (counter <= max) {
            if (predicate.test(counter)) {
                print.run();
                counter++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public void fizz(final Runnable printFizz) throws InterruptedException {
        synchronizedPrint(printFizz, n -> n % 3 == 0 && n % 5 != 0);
    }

    public void buzz(final Runnable printBuzz) throws InterruptedException {
        synchronizedPrint(printBuzz, n -> n % 5 == 0 && n % 3 != 0);
    }

    public void fizzbuzz(final Runnable printFizzBuzz) throws InterruptedException {
        synchronizedPrint(printFizzBuzz, n -> n % 15 == 0);
    }

    public void number(final IntConsumer printNumber) throws InterruptedException {
        synchronizedPrint(() -> printNumber.accept(counter), n -> n % 3 != 0 && n % 5 != 0);
    }

}
