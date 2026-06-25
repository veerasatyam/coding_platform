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
