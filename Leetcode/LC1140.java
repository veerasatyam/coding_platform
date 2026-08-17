import java.util.Arrays;
//pure recursion 
class Solution {
    public int stoneGameII(int[] piles) {
        return helper(0, piles, 1, 1);
    }

    private int helper(int idx, int[] piles, int M, int person) { // solve for alice
        if (idx >= piles.length) return 0;

        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for (int X = 1; X <= 2 * M && idx + X <= piles.length; X++) {
            stones += piles[idx + X - 1];

            if (person == 1) // for alice 
                result = Math.max(result, stones + helper(idx + X, piles, Math.max(M, X), 0));
            else
                result = Math.min(result, helper(idx + X, piles, Math.max(M, X), 1));
        }
        return result;
    }
}


// memoization

class Solution {
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length + 1][piles.length + 1][2];
        for(int[][] d : dp){
            for(int[] row : d) Arrays.fill(row,-1);
        }
        return helper(0, piles, 1, 1,dp);
    }

    private int helper(int idx, int[] piles, int M, int person,int[][][] dp) {
        if (idx >= piles.length) return 0;
        if(dp[idx][M][person] != -1) return dp[idx][M][person];
        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        for (int X = 1; X <= 2 * M && idx + X <= piles.length; X++) {
            stones += piles[idx + X - 1];
            if (person == 1)
                result = Math.max(result, stones + helper(idx + X, piles, Math.max(M, X), 0,dp));
            else
                result = Math.min(result, helper(idx + X, piles, Math.max(M, X), 1,dp));
        }

        return dp[idx][M][person] = result;
    }
}