// using pure recursion
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        return helper(n,price);
    }
    private int helper(int n,int[] price){
        if(n == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            int cost = price[i - 1] + helper(n - i,price);
            max = Math.max(max,cost);
        }
        return max;
    }
}



// using knapsack approach
class Solution {
    public int cutRod(int[] price) {
        return helper(0,price,price.length);
    }
    private int helper(int index,int[] price,int n){
        if(index == n) return 0;
        int notTake = helper(index + 1,price,n);
        int take = Integer.MIN_VALUE;
        if(index + 1 <= n) take = price[index] + helper(index,price,n - (index + 1));
        return Math.max(take,notTake);
    }
}


// using recursion + memoization
class Solution {
    public int cutRod(int[] price) {
        int[][] dp = new int[price.length][price.length + 1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,price,price.length,dp);
    }
    private int helper(int index,int[] price,int n,int[][] dp){
        if(index == price.length) return 0;
        if(dp[index][n] != -1) return dp[index][n];
        int notTake = helper(index + 1,price,n,dp);
        int take = Integer.MIN_VALUE;
        if(index + 1 <= n) take = price[index] + helper(index,price,n - (index + 1),dp);
        return dp[index][n] = Math.max(take,notTake);
    }
}