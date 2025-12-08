import java.util.Stack;

class Solution {
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


// optimal solution 


import java.util.Stack;

public class Histogram {
    public static int largestRectangleArea(int[] heights) {
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

