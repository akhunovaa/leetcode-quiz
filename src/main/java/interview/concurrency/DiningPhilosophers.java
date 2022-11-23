package interview.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    public ReentrantLock[] forks = new ReentrantLock[5];
    public Semaphore taken = new Semaphore(4);      // Avoid deadlock

    public DiningPhilosophers() {
        forks[0] = new ReentrantLock();
        forks[1] = new ReentrantLock();
        forks[2] = new ReentrantLock();
        forks[3] = new ReentrantLock();
        forks[4] = new ReentrantLock();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 4) % 5;

        taken.acquire();

        forks[left].lock();
        pickLeftFork.run();

        forks[right].lock();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        forks[left].unlock();

        putRightFork.run();
        forks[right].unlock();

        taken.release();
    }


}
