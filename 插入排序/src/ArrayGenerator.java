import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] generateOrderArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // 随机数组[0,bound)
    public static Integer[] generatorRandomArray(int n, int bound) {

        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}
