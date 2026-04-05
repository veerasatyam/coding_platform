class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if(k == 0) return 0;
        if( k > n/2) return -1;
        int[] cost = new int[n];
        for(int i = 0;i<n;i++){
            int left = nums[(i - 1 + n) % n];
            int right = nums[(i + 1) % n];
            cost[i] = Math.max(0,Math.max(left,right) + 1 - nums[i]);
        }
        int case1 = cost[0] + helper(2,k-1,cost,n-2);
        int case2 = helper(1,k,cost,n-1);
        return Math.min(case1,case2) == Integer.MIN_VALUE ? 0 :Math.min(case1,case2);
    }
    private int helper(int i,int k,int[] cost,int n){
        if(k == 0) return 0;
        if(i > n) return Integer.MAX_VALUE;
         int next = helper(i + 2, k - 1, cost, n);
        int take = (next >= Integer.MAX_VALUE) ? INF : cost[i] + next;
        int skip = helper(i+1,k,cost,n);
        return Math.min(take,skip);
    }
}



// memoization
class Solution {
    static final int INF = (int)1e9;
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return 0;
        if (k > n / 2) return -1;
        int[] cost = new int[n];
        for (int i = 0;i < n;i++) {
            int left = nums[(i - 1 + n) % n];
            int right = nums[(i + 1) % n];
            cost[i] = Math.max(0, Math.max(left, right) + 1 - nums[i]);
        }
        int[][] dp1 = new int[n][k + 1];
        fill(dp1);
        int case1 = cost[0] + helper(2,k - 1,cost,n - 2,dp1);
        int[][] dp2 = new int[n][k + 1];
        fill(dp2);
        int case2 = helper(1,k,cost,n - 1,dp2);
        int ans = Math.min(case1, case2);
        return ans >= INF ? -1 : ans;
    }
    private int helper(int i,int k,int[] cost,int end,int[][] dp) {
        if (k == 0) return 0;
        if (i > end) return INF;
        if (dp[i][k] != -1) return dp[i][k];
        int skip = helper(i + 1,k,cost,end,dp);
        int next = helper(i + 2,k - 1,cost,end,dp);
        int take = (next >= INF) ? INF : cost[i] + next;
        return dp[i][k] = Math.min(skip,take);
    }
    private void fill(int[][] dp) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    }
}