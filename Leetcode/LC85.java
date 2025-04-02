import java.util.Stack;
class Solution {
    public int maximalRectangle(char[][] matrix) {
       int n = matrix.length,m=matrix[0].length;
       int[][] imatrix = new int[n][m];
       for(int j=0;j<m;j++)
       {
          int c=0;
          for(int i=0;i<n;i++)
          {
            if(matrix[i][j]=='0') c=0;
            else {
                c++;
                imatrix[i][j]=c;
            }
          }
       }
       int ans=0;
       for(int i=0;i<n;i++){
         ans = Math.max(ans,largestRectangleArea(imatrix[i]) );
       }
       return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] p1 = new int[n];
        int[] p2 = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            p1[i] = -1;
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                p1[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            p2[i] = n;
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                p2[i] = st.peek();
            }
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int width = p2[i] - p1[i] - 1;
            int area = width * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
}