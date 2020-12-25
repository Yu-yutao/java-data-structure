public class Test {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.addFirst(100);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

//        arr.remove(99);
    }
}
