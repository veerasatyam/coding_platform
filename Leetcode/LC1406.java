// pure recursion 

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int scoreDiff = helper(stoneValue, 0, n);
        if(scoreDiff > 0) return "Alice";
        else if(scoreDiff < 0) return "Bob";
        else return "Tie";
    }
    private int helper(int[] arr,int i,int n){
        if(i >= n) return 0;
        int sum = 0;
        int maxDiff = Integer.MIN_VALUE;
        for(int k = 1; k <= 3 && i + k <= n; k++){
            sum += arr[i + k - 1];
            maxDiff = Math.max(maxDiff, sum - helper(arr, i + k, n));
        }
        return maxDiff;
    }
}


// memoization
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int scoreDiff = helper(stoneValue, 0, n, dp);
        if(scoreDiff > 0) return "Alice";
        else if(scoreDiff < 0) return "Bob";
        else return "Tie";
    }
    private int helper(int[] arr,int i,int n,int[] dp){
        if(i >= n) return 0;
        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        int sum = 0;
        int maxDiff = Integer.MIN_VALUE;
        for(int k = 1; k <= 3 && i + k <= n; k++){
            sum += arr[i + k - 1];
            maxDiff = Math.max(maxDiff, sum - helper(arr, i + k, n));
        }
        return dp[i] = maxDiff;
    }
}
// tabulation
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1]; // dp[i] = best score difference (current - opponent) from index i onward
        
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            dp[i] = Integer.MIN_VALUE;
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                sum += stoneValue[i + k - 1];
                dp[i] = Math.max(dp[i], sum - dp[i + k]);
            }
        }
        
        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }
}