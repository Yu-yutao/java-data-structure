import java.util.Random;

public class Test2 {

    private static double testQueue(Queue<Integer> q, int optCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < optCount; i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
            System.out.println("enqueue:"+ q);
        }
        for (int i = 0; i < optCount; i++){
            q.dequeue();
            System.out.println("dequeue:"+ q);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int optCount = 20;

//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue, optCount);
//        System.out.println("ArrayQueue cost time: " + time1 + " s.");
        LoopQueue2<Integer> loopQueue = new LoopQueue2<>();
        double time2 = testQueue(loopQueue, optCount);
        System.out.println("LoopQueue cost time: " + time2 + " s.");
    }
}
