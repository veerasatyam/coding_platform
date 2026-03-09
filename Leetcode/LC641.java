class MyCircularDeque {
    int size,front,rear;
    int[] dequeue;
    public MyCircularDeque(int k) {
        size = k;
        front = rear = -1;
        dequeue = new int[k];
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(isEmpty()) rear++;
        front = (front-1+size)%size;
        dequeue[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(isEmpty()) front++;
        rear =(rear+1)%size;
        dequeue[rear]=value;
        return true; 
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(front==rear){
            dequeue[front] = 0;
            front = rear = -1;
        }
        else{
            dequeue[front] = 0;
            front = (front+1)%size;
        }
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(front==rear){
            dequeue[rear] = 0;
            front= rear = -1;
        }else{
            dequeue[rear] = 0;
            rear = (rear-1+size)%size;
        }
        return true;
    }
    
    public int getFront() {
        return front==-1 ? -1 : dequeue[front];
    }
    
    public int getRear() {
        return rear==-1 ? -1 : dequeue[rear];
    }
    
    public boolean isEmpty() {
        if(front==-1) return true;
        return false;
    }
    
    public boolean isFull() {
        if(front==(rear+1)%size) return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */