class Solution {
    public int maxProfit(int[] arr, int k) {
        return helper(arr, k, 0, 0);
    }

    private int helper(int[] arr, int k, int i, int buy) {
        if (i == arr.length) return 0;
        int profit;
        if (buy == 0) {
            int take = -arr[i] + helper(arr, k, i + 1, 1);
            int notTake = helper(arr, k, i + 1, 0);
            profit = Math.max(take, notTake);
        } else {
            int sell = arr[i]-k + helper(arr,k,i + 1,0);
            int notSell = helper(arr,k,i + 1,1);
            profit = Math.max(sell,notSell);
        }
        return profit;
    }
}

// memoization + recursion 
class Solution {
    public int maxProfit(int[] arr, int k) {
        int[][] dp = new int[arr.length + 1][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(arr, k, 0, 0,dp);
    }

    private int helper(int[] arr, int k, int i, int buy,int[][] dp) {
        if (i == arr.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        int profit;
        if (buy == 0) {
            int take = -arr[i] + helper(arr, k, i + 1, 1,dp);
            int notTake = helper(arr, k, i + 1, 0,dp);
            profit = Math.max(take, notTake);
        } else {
            int sell = arr[i]-k + helper(arr,k,i + 1,0,dp);
            int notSell = helper(arr,k,i + 1,1,dp);
            profit = Math.max(sell,notSell);
        }
        return dp[i][buy] = profit;
    }
}


// tabulation 
class Solution {
    public int maxProfit(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int i = n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                int profit;
                if (buy == 0) {
                    int take = -arr[i] + dp[i+1][1];
                    int notTake = dp[i+1][0];
                    profit = Math.max(take, notTake);
                } else {
                    int sell = arr[i]-k + dp[i+1][0];
                    int notSell = dp[i+1][1];
                    profit = Math.max(sell,notSell);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
    }
}

// space optimaisation
class Solution {
    public int maxProfit(int[] arr, int k) {
        int n = arr.length;
         int n = arr.length;
        int noStock = 0, inHand = 0;
        for (int i = n - 1; i >= 0; i--) {
            int newNoStock = Math.max(noStock, inHand - arr[i]);
            int newInHand = Math.max(inHand, arr[i] - k + noStock);
            noStock = newNoStock;
            inHand = newInHand;
        }
        return noStock;
    }
}