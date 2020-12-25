public class Array<E> {

    /*
        动态数组
        size: 数组数据
        capacity: 容量
     */

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
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
    public void addLast(E e) {
        add(size, e);
    }

    // 添加数组头
    public void addFirst(E e) {
        add(0, e);
    }

    // 向指定位置添加元素
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed. Required index >= 0 and index <= size.");

        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
            // 数组已满进行扩容
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 删除指定位置的元素,并返回
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Delete failed. Required index >= 0 and index <= size.");

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;  // loitering objects != memory leak

        // 缩小容量
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    // 删除头部元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除尾部
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除元素,元素中存在重复元素，只删除一个
    public void removeElement(E e) {
        int index = findIndex(e);
        if (index != -1)
            remove(index);
    }

    // 获取index索引位置的元素
    E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index位置元素为e
    void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        data[index] = e;
    }

    // 是否包含某个元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查询元素位置
    public int findIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
