import java.util.ArrayList;
//pure recursion
public class Solution {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        return helper(values, weights, n - 1, w);
    }

    private static int helper(ArrayList<Integer> values, ArrayList<Integer> weights, int index, int w) {
        if (index == 0) {
            if (weights.get(0) <= w) return values.get(0);
            return 0;
        }
        int notTake = helper(values, weights, index - 1, w);
        int take = 0;
        if (weights.get(index) <= w)
            take = values.get(index) + helper(values, weights, index - 1, w - weights.get(index));
        return Math.max(take, notTake);
    }
}

//recursion + memorization

import java.util.*;

public class Solution {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(values, weights, n - 1, w, dp);
    }

    private static int helper(ArrayList<Integer> values, ArrayList<Integer> weights, int index, int w, int[][] dp) {
        if (index == 0) {
            if (weights.get(0) <= w) return values.get(0);
            return 0;
        }
        if (dp[index][w] != -1) return dp[index][w];
        int notTake = helper(values, weights, index - 1, w, dp);
        int take = 0;
        if (weights.get(index) <= w)
            take = values.get(index) + helper(values, weights, index - 1, w - weights.get(index), dp);
        return dp[index][w] = Math.max(take, notTake);
    }
}


//tabaulation 
import java.util.*;

public class Solution {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n][w + 1];
        for (int cap = weights.get(0); cap <= w; cap++) dp[0][cap] = values.get(0);
		 for (int i = 1; i < n; i++) {
            for (int cap = 0; cap <= w; cap++) {
                int notTake = dp[i - 1][cap];
                int take = 0;
                if (weights.get(i) <= cap)
                    take = values.get(i) + dp[i - 1][cap - weights.get(i)];
                dp[i][cap] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][w];
        
    }
}

//space optimization 
import java.util.*;

public class Solution {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[] dp = new int[w + 1];
        for (int cap = weights.get(0); cap <= w; cap++) dp[cap] = values.get(0);
        for (int i = 1; i < n; i++) {
            for (int cap = w; cap >= 0; cap--) {
                int notTake = dp[cap];
                int take = 0;
                if (weights.get(i) <= cap)
                    take = values.get(i) + dp[cap - weights.get(i)];
                dp[cap] = Math.max(take, notTake);
            }
        }
        return dp[w];
    }
}
