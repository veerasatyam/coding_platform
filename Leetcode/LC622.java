class MyCircularQueue {
    int size,front,rear;
    int[] queue;
    public MyCircularQueue(int k) {
        size = k;
        front = rear = -1;
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(isEmpty()) front++;
        rear = (rear+1)%size;
        queue[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(front==rear){
            queue[front] = 0;
            front = rear = -1;
        }
        else{
            queue[front] = 0;
            front = (front+1)%size;
        }
        return true;
    }
    
    public int Front() {
        return front == -1? -1 : queue[front];
    }
    
    public int Rear() {
        return rear == -1? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        if(front==-1) return true;
        return false;
    }
    
    public boolean isFull() {
        if((rear+1)%size==front) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
