// recursion 
class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        int val = st.pop();
        sortStack(st);
        pushStack(st,val);
    }
    private static void pushStack(Stack<Integer> st,int val){
        if(st.isEmpty() || st.peek() <= val){
            st.push(val);
            return;
        }
        int top = st.pop();
        pushStack(st, val);
        st.push(top);
    }
}

// using a temperory stack 
// recursion 
class Solution {
    public void sortStack(Stack<Integer> st) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!input.isEmpty()){
            int tmp = input.pop();
            while(!tmpStack.isEmpty() && tmpStack.peek()< tmp){
            input.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        return tmpStack;
    }
}