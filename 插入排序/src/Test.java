public class Test {

    public static void main(String[] args) {
        Integer arr[] = {1, 3, 2, 9, 8, 6, 5};
        InsertionSort.sort2(arr);
        System.out.println("排序之后");
        for (int n : arr) {
            System.out.print(n);
        }
    }
}
