import java.util.*;

class Solution {
    public int minDifference(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        int n = arr.length;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        for (int j = target; j >= 0; j--) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }

        return sum;
    }
}
