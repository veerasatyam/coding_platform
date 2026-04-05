// pure recursion
class Solution {
    public int totalWays(int[] arr, int target) {
        return helper(0,0,arr,target);
    }
    private int helper(int i,int currSum, int[] arr, int target){
        if(i == arr.length){
            if(target == currSum) return 1;
            return 0;
        }
        int add = helper(i+1,currSum + arr[i],arr,target);
        int sub = helper(i+1,currSum - arr[i],arr,target);
        return add + sub;
    }
}

// recursion + memoization
class Solution {
    public int totalWays(int[] arr, int target) {
        int totalSum = 0;
        for(int a : arr) totalSum += a;
        int[][] dp = new int[arr.length + 1][2*totalSum + 1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,0,arr,totalSum,target,dp);
    }
    private int helper(int i,int currSum, int[] arr,int s, int target,int[][] dp){
        if(i == arr.length){
            if(target == currSum) return 1;
            return 0;
        }
        if(dp[i][currSum + s] != -1) return dp[i][currSum + s];
        int add = helper(i+1,currSum + arr[i],arr,s,target,dp);
        int sub = helper(i+1,currSum - arr[i],arr,s,target,dp);
        return dp[i][currSum + s] = add + sub;
    }
}



// tabulation
class Solution {
    public int totalWays(int[] arr, int target) {
        int totalSum = 0;
        int n = arr.length;
        for (int a : arr) totalSum += a;
        if (target > totalSum || target < -totalSum) return 0;
        int[][] dp = new int[n + 1][2 * totalSum + 1];
        dp[n][totalSum] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int currSum = -totalSum; currSum <= totalSum; currSum++) {
                int idx = currSum + totalSum;
                int add = 0, sub = 0;
                if (currSum + arr[i] <= totalSum) add = dp[i + 1][currSum + arr[i] + totalSum];
                if (currSum - arr[i] >= -totalSum) sub = dp[i + 1][currSum - arr[i] + totalSum];
                dp[i][idx] = add + sub;
            }
        }
        return dp[0][target + totalSum];
    }
}