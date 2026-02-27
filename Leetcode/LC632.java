class Solution {
    public int calPoints(String[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){

            String s = arr[i];

            if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                st.push(st.peek() * 2);
            }
            else if(s.equals("+")) {
                int num1 = st.pop();
                int num2 = st.peek();
                st.push(num1);
                st.push(num1 + num2);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}
