/**
 * 没有size的版本
 * @param <E>
 */

public class LoopQueue2<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;

    public LoopQueue2(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue2() {
        this(10);
    }

    @Override
    public int getSize() {
        // 注意此时getSize的逻辑:
        // 如果tail >= front，非常简单，队列中的元素个数就是tail - front
        // 如果tail < front，说明我们的循环队列"循环"起来了，此时，队列中的元素个数为：
        // tail - front + data.length
        // 画画图，看能不能理解为什么？
        //
        // 也可以理解成，此时，data中没有元素的数目为front - tail,
        // 整体元素个数就是 data.length - (front - tail) = data.length + tail - front
        return tail >= front ? tail - front : tail - front + data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        int sz = getSize();
        for (int i = 0; i < sz; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = sz;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if (front == tail)
            throw new IllegalArgumentException("Queue is Empty");
        return data[front];
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d \n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
