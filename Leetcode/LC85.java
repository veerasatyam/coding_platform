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
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}