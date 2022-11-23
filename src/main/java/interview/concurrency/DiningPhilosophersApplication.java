package interview.concurrency;

public class DiningPhilosophersApplication {

    public static void main(String[] args) {
        testDiningPhilosophers();
    }

    private static void testDiningPhilosophers() {

        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();

        Runnable pickUpLeftFork = () -> {
            System.out.println("picked up left fork by " + Thread.currentThread().getName());
        };
        Runnable pickUpRightFork = () -> {
            System.out.println("picked up right fork by " + Thread.currentThread().getName());
        };

        Runnable eat = () -> {
            System.out.println("eat by " + Thread.currentThread().getName());

        };

        Runnable putDownLeftFork = () -> {
            System.out.println("put down left fork by " + Thread.currentThread().getName());
        };

        Runnable putDownRightFork = () -> {
            System.out.println("put down right fork by " + Thread.currentThread().getName());
        };

        /*
         *  number of attempts to eat
         */
        int n = 2;

        Thread f0 = new Thread(() -> {
            try {

                for (int i = 0; i < n; i++) {
                    diningPhilosophers.wantsToEat(0, pickUpLeftFork, pickUpRightFork, eat, putDownLeftFork, putDownRightFork);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "filo-0");

        Thread f1 = new Thread(() -> {
            try {

                for (int i = 0; i < n; i++) {
                    diningPhilosophers.wantsToEat(1, pickUpLeftFork, pickUpRightFork, eat, putDownLeftFork, putDownRightFork);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "filo-1");

        Thread f2 = new Thread(() -> {
            try {

                for (int i = 0; i < n; i++) {
                    diningPhilosophers.wantsToEat(2, pickUpLeftFork, pickUpRightFork, eat, putDownLeftFork, putDownRightFork);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "filo-2");

        Thread f3 = new Thread(() -> {
            try {

                for (int i = 0; i < n; i++) {
                    diningPhilosophers.wantsToEat(3, pickUpLeftFork, pickUpRightFork, eat, putDownLeftFork, putDownRightFork);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "filo-3");

        Thread f4 = new Thread(() -> {
            try {

                for (int i = 0; i < n; i++) {
                    diningPhilosophers.wantsToEat(0, pickUpLeftFork, pickUpRightFork, eat, putDownLeftFork, putDownRightFork);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "filo-4");


        f0.start();
        f1.start();
        f2.start();
        f3.start();
        f4.start();
    }
}
