public class Test2 {

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedList = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            linkedList.push(i);
            System.out.println(linkedList);
        }

        linkedList.pop();
        System.out.println(linkedList);


        linkedList.pop();
        System.out.println(linkedList);
    }
}
