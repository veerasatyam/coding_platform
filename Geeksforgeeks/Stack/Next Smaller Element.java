// brute force approach
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
       int n = arr.length;
       ArrayList<Integer> ans = new ArrayList<>();
       for(int i = 0;i < n; i++){
        boolean found = false;
          for(int j = i + 1; j < n; j++){
            if(arr[j] < arr[i]){
                ans.add(arr[j]);
                found = true;
                break;
            }
          }
          if(!found) ans.add(-1);
       }
       return ans;
    }
}

// optimal approach using monotonic stack
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1;i >= 0;i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans.add(st.isEmpty() ? -1 : arr[st.peek()]);
            st.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }
}