package stack;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueSample {

    public static void main(String[] args) {

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(() -> {
            String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};

            for (int i = 0; i < planets.length && !Thread.interrupted(); ) {
                String planet = planets[i];
                try {
                    Thread.sleep(5000);  // чтобы потребитель немного не успевал за производителем
                    arrayBlockingQueue.put(planet);
                    System.out.println("Producer: записал в очередь " + planet + ", число элементов в очереди: " + arrayBlockingQueue.size());
                    i++;
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            StringBuilder sb = new StringBuilder();

            while (!Thread.interrupted()) {
                try {
                    sb.setLength(0);
                    Thread.sleep(8000); // чтобы потребитель немного не успевал за производителем
                    sb.append(arrayBlockingQueue.take());
                    System.out.println("Consumer: обработал из очереди " + sb.reverse() + ", число элементов в очереди: " + arrayBlockingQueue.size());
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        producer.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.start();

    }
}
