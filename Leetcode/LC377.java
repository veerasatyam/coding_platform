// pure recursion
class Solution {
    public int combinationSum4(int[] nums, int target) {
        return helper(nums,target);
    }
    private int helper(int[] nums,int target){
        if(target==0)return 1;
        if(target<0) return 0;
        int ways=0;
        for(int a : nums)ways = ways + helper(nums,target-a);
        return ways;
    }
}


// memoiation
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return helper(nums,target,dp);
    }
    private int helper(int[] nums,int target,int[] dp){
        if(target==0)return 1;
        if(target<0) return 0;
        if(dp[target]!=-1) return dp[target];
        int ways=0;
        for(int a : nums)ways = ways + helper(nums,target-a,dp);
        return dp[target] = ways;
    }
}


// tabulation 

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) for (int a : nums) if (i - a >= 0)  dp[i] += dp[i - a];
        return dp[target];
    }
}
