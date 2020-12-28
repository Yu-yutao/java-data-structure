/*
    使用size,节省一个单位
 */

public class LoopQueue1<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue1(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue1() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");

        // 注意，我们的循环遍历打印队列的逻辑也有相应的更改 :-)
        for(int i = 0; i < size; i ++){
            res.append(data[(front + i) % data.length]);
            if((i + front + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();

    }
}
