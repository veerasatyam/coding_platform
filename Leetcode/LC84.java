class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i;j < n;j++){
                minHeight = Math.min(minHeight,heights[j]);
                int width = j - i + 1;
                maxArea = Math.max(maxArea,minHeight * width);
            }
        }
        return maxArea;
    }
}



// we can solve this using the next smaller elment and previous smaller elment so at that particular index we can find out how long we can extend the height[i] bar to the two ends
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        // prev smaller element
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< n;i++){
            prevSmaller[i] = -1;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(!stack.isEmpty()) prevSmaller[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        // nextSmallest element
        int[] nextSmaller = new int[n];
        for(int i = n-1; i >=0;i--){
            nextSmaller[i] = n;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(!stack.isEmpty()) nextSmaller[i] = stack.peek();
            stack.push(i);
        }
        for(int i = 0; i< n;i++){
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}


// same approach as above approach but while poping the element that means that the current element is the next smaller elment for the poped element right
// that is the intution behind the optimisation
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0;i <= n;i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}