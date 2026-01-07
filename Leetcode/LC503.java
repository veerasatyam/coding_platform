// brute force
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i=0;i <n;i++) {
            ans[i] = -1;
            for (int j =1;j<n;j++) {
                int idx = (i+j)%n;
                if(nums[idx]>nums[i]){
                    ans[i] = nums[idx];
                    break;
                }
            }
        }
        return ans;
    }
}

// optimal solution using monotonic stack
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> idx_stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<nums.length;i++){
            while(!idx_stack.isEmpty() && nums[idx_stack.peek()] < nums[i]){
                ans[idx_stack.pop()] = nums[i];
            }
            idx_stack.push(i);
        }
        for(int i=0;i<idx_stack.peek();i++){
            while(!idx_stack.isEmpty() && nums[idx_stack.peek()] < nums[i]) ans[idx_stack.pop()] = nums[i];
        }
        return ans;
    }
}

// another approach same as the second approach but with a single for loop

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> idx_stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=0;i<2*nums.length;i++){
            int idx = i % nums.length;
            while(!idx_stack.isEmpty() && nums[idx_stack.peek()] < nums[iidx]){
                ans[idx_stack.pop()] = nums[idx];
            }
            idx_stack.push(idx);
        }
        return ans;
    }
}