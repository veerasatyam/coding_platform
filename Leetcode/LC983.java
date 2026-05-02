// pure recursion

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return helper(0, days, costs, 0);
    }

    private int helper(int i, int[] days, int[] costs, int validity) {
        if (i >= days.length) return 0;
        if (validity >= days[i]) return helper(i + 1,days,costs,validity);
        int oneDay = costs[0] + helper(i + 1,days,costs,days[i]);
        int sevenDay = costs[1] + helper(i + 1,days,costs,days[i] + 6);
        int thirtyDay = costs[2] + helper(i + 1,days,costs,days[i] + 29);
        return Math.min(oneDay, Math.min(sevenDay,thirtyDay));
    }
}


// recusion + memoization
class Solution {
    public int mincostTickets(int[] days, int[] costs){
        int[][] dp = new int[days.length][365 + 31];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,days,costs,0,dp);
    }

    private int helper(int i, int[] days, int[] costs, int validity,int[][] dp) {
        if (i >= days.length) return 0;
        if(dp[i][validity] != -1) return dp[i][validity];
        if (validity >= days[i]) return dp[i][validity] = helper(i + 1,days,costs,validity,dp);
        int oneDay = costs[0] + helper(i + 1,days,costs,days[i],dp);
        int sevenDay = costs[1] + helper(i + 1,days,costs,days[i] + 6,dp);
        int thirtyDay = costs[2] + helper(i + 1,days,costs,days[i] + 29,dp);
        return dp[i][validity] = Math.min(oneDay, Math.min(sevenDay,thirtyDay));
    }
}

// tabulation
class Solution {
    public int mincostTickets(int[] days, int[] costs){
        int n = days.length;
        int[][] dp = new int[days.length + 1][365 + 31];
        for(int i = n;i >= 0;i--){
            for(int validity = 0;validity <= 365 + 31;validity++){
                if (validity >= days[i]) dp[i][validity] = dp[i+1][validity];
                    int oneDay = costs[0] + dp[i + 1][days[i]];
                    int sevenDay = costs[1] + dp[i + 1][days[i] + 6];
                    int thirtyDay = costs[2] + dp[i + 1][days[i] + 29];
                    dp[i][validity] = Math.min(oneDay, Math.min(sevenDay,thirtyDay));
            }
        }
        return dp[0][0];
    }
}