public class Array {

    /*
        动态数组
        size: 数组数据
        capacity: 容量
     */

    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参构造函数，默认capacity=10
    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 容量
    public int getCapacity() {
        return data.length;
    }

    // 添加元素
    public void addLast(int e) {
        if (size == data.length) throw new IllegalArgumentException("AddLast failed. Array is full");
        data[size] = e;
        size++;
    }

    // 向指定位置添加元素
    public void add(int index, int e){
        
    }
}
