public class Test {

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);
        Integer[] arr2 = arr;

        long startTime = System.nanoTime();
        SelectionSort.sort(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException("SelectionSort failed");
        System.out.println("Selection sort cost: " + time + " s");

        long startTime2 = System.nanoTime();
        InsertionSort.sort2(arr);
        long endTime2 = System.nanoTime();

        double time2 = (endTime2 - startTime2) / 1000000000.0;
        if (!SortingHelper.isSorted(arr2))
            throw new RuntimeException("SelectionSort failed");
        System.out.println("Selection sort cost: " + time2 + " s");
    }
}
