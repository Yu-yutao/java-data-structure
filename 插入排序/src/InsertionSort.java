public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    // swap 实际有三次操作
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static <E> void swap(E[] arr, int j, int i) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 可以通过平移来优化swap的过程
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将arr[i]插入合适的位置
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
