// pure recursion 
class Solution {
    public int climbStairs(int n, int[] costs) {
        return helper(0, costs);
    }

    private int helper(int i, int[] costs) {
        if (i == costs.length)return 0;
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= 3; j++) {
            int nextStep = i + j;
            if (nextStep <= costs.length) {
                int jumpCost = 0;
                if (nextStep > 0) {
                    jumpCost = costs[nextStep - 1] + j * j;
                }
                min = Math.min(min, jumpCost + helper(nextStep, costs));
            }
        }
        return min;
    }
}

// memoization
class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[costs.length + 1];
        Arrays.fill(dp, -1);
        return helper(0, costs, dp);
    }

    private int helper(int i, int[] costs, int[] dp) {
        if (i == costs.length)return 0;
        if (dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= 3; j++) {
            int nextStep = i + j;
            if (nextStep <= costs.length) {
                int jumpCost = 0;
                if (nextStep > 0) {
                    jumpCost = costs[nextStep - 1] + j * j;
                }
                min = Math.min(min, jumpCost + helper(nextStep, costs));
            }
        }
        return dp[i] = min;
    }
}


// tabulation
class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[costs.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= costs.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 3; j++) {
                int nextStep = i - j;
                if (nextStep >= 0) {
                    int jumpCost = costs[i - 1] + j * j;
                    min = Math.min(min, jumpCost + dp[nextStep]);
                }
            }
            dp[i] = min;
        }
        return dp[costs.length];
    }
}

