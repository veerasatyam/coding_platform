class myQueue {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public myQueue(int n) {
        queue = new int[n];
        capacity = n;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int x) {
        if (isFull()) return;
        rear = (rear + 1) % capacity;
        queue[rear] = x;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) return;
        front = (front + 1) % capacity;
        size--;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }
}