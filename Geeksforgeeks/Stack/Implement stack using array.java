class myStack {

    int[] stack;
    int top;
    int capacity;

    public myStack(int n) {
        stack = new int[n];
        capacity = n;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int x) {
        if (isFull()) return;
        stack[++top] = x;
    }

    public void pop() {
        if (isEmpty()) return;
        top--;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return stack[top];
    }
}