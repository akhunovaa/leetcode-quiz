package stack;

public class QueueTest {

    public static void main(String[] args) {
        testQueue();
    }

    private static void testQueue() {
        Queue<Integer> queue = new SimpleQueue<>();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            queue.add(i);
        }

        System.out.println("\n");

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
