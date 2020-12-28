/*
    链表的性能问题：

 */

/*
    // 创建一个动态数组，再创建一个链表
    Array<Integer> array = new Array<>();
    LinkedList<Integer> list = new LinkedList<>();

    // 对于 1000 万规模的数据
    int n = 10000000;
    System.out.println("n = " + n);

    // 计时，看将 1000 万个元素放入数组中，时间是多少
    long startTime = System.nanoTime();
    // 对于数组，我们使用 addLast，每一次操作时间复杂度都是 O(1) 的
    for(int i = 0; i < n; i ++)
        array.addLast(i);
    long endTime = System.nanoTime();
    double time = (endTime - startTime) / 1000000000.0;
    System.out.println("Array : " + time + " s");

    // 计时，看将 1000 万个元素放入链表中，时间是多少
    startTime = System.nanoTime();
    // 对于链表，我们使用 addFirst，每一次操作时间复杂度都是 O(1) 的
    for(int i = 0; i < n; i ++)
        list.addFirst(i);
    endTime = System.nanoTime();
    time = (endTime - startTime) / 1000000000.0;
    System.out.println("LinkedList : " + time + " s");
 */

/*
    n = 10000000
    Array : 0.203133984 s
    LinkedList : 3.418495718 s
 */



