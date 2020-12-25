public class Test {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
        
        System.out.println("-------------------------------------------");

        LoopQueue<Integer> queue2 = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue2.enqueue(i);
            System.out.println(queue2);

            if (i % 3 == 2) {
                queue2.dequeue();
                System.out.println(queue2);
            }
        }
    }
}
