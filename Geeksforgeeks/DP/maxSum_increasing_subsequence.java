
// pure recursion 
class Solution {
    public int maxSumIS(int nums[]) {
        return helper(nums, nums.length - 1, -1);  
    }
    private int helper(int[] nums, int index, int nextIndex) {
        if (index < 0) return 0;
        int notTake = helper(nums, index - 1, nextIndex);
        int take = 0;
        if (nextIndex == -1 || nums[index] < nums[nextIndex]) {
            take = nums[index] + helper(nums, index - 1, index);
        }
        return Math.max(take, notTake);
    }
}


// recursion + memoization
class Solution {
    public int maxSumIS(int nums[]) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(nums, nums.length - 1, -1,dp);  
    }
    private int helper(int[] nums, int index, int nextIndex,int[][] dp) {
        if (index < 0) return 0;
        if(nextIndex != -1) if(dp[index][nextIndex] != -1) return dp[index][nextIndex];
        int notTake = helper(nums, index - 1, nextIndex,dp);
        int take = 0;
        if (nextIndex == -1 || nums[index] < nums[nextIndex]) {
            take = nums[index] + helper(nums, index - 1, index,dp);
        }
        if(nextIndex == -1) return Math.max(take,notTake);
        return dp[index][nextIndex] = Math.max(take, notTake);
    }
}


// tabulation
// 

//space optimasation
class Solution {
    public int maxSumIS(int nums[]) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxSum = 0;
        for (int i = 0;i < n;i++){
            dp[i] = nums[i];
            for (int j = 0;j < i;j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],nums[i] + dp[j]);
                }
            }
            maxSum = Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }
}