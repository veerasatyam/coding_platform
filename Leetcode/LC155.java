class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


import java.util.*;

// Class to implement Minimum Stack
class MinStack {
    private Stack<int[]> st;
    public MinStack() {
        st = new Stack<>();
    }
    public void push(int value) {
        if (st.isEmpty()) {
            st.push(new int[]{value, value});
            return;
        }
        int mini = Math.min(getMin(), value);
        st.push(new int[]{value, mini});
    }
    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }
    public int getMin() {
        return st.peek()[1];
    }
}



// optimal approach 
import java.util.Stack;

// Class to implement Minimum Stack
class MinStack {
    private Stack<Integer> st;
    private int mini;
    public MinStack() {
        st = new Stack<>();
    }
    public void push(int value) {
        if (st.isEmpty()) {
            mini = value;
            st.push(value);
            return;
        }
        if (value > mini) {
            st.push(value);
        } else {
            st.push(2 * value - mini);
            mini = value;
        }
    }
    public void pop() {
        if (st.isEmpty()) return;
        int x = st.pop();
        if (x < mini) {
            mini = 2 * mini - x;
        }
    }
    public int top() {
        if (st.isEmpty()) return -1;
        int x = st.peek();
        if (mini < x) return x;
        return mini;
    }
    public int getMin() {
        return mini;
    }
}