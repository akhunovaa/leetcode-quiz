package interview.seven;

public class Question {

    /**
     * Какой будет вывод?
     * 1# Thread end. и зависнет
     * 2# Thread end.Main end
     * 3# Результат неизвестен
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.print("Thread end."));

        synchronized (thread) {
            thread.start();
            thread.wait();
        }

        System.out.print("Main end");
    }

    /*
    Правильный ответ #2
    Thread end.Main end

    Потому что у Thread автоматически вызовется notifyAll();
     */

    /*
    Synchronization on local variable 'thread'
 Inspection info: Reports synchronization on a local variable or parameter.
 It is very difficult to guarantee correctness when such synchronization is used.
 It may be possible to improve code like this by controlling access through e.g.
 a synchronized wrapper class, or by synchronizing on a field.
     */
}
