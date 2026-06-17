// pure recusion 
class Solution {
    static int palPartition(String s) {
        return helper(0, s) - 1;
    }

    private static int helper(int i, String s) {
        if (i == s.length()) return 0;
        int minCost = Integer.MAX_VALUE;
        for (int j = i;j < s.length();j++) {
            String str = s.substring(i, j + 1);

            if (isPalindrome(str)) {
                int cost = 1 + helper(j + 1, s);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

// recursion + memoization 
class Solution {
    static int palPartition(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp,-1);
        return helper(0, s, dp) - 1;
    }

    private static int helper(int i, String s, int[] dp) {
        if (i == s.length()) return 0;
        int minCost = Integer.MAX_VALUE;
        if(dp[i] != -1) return dp[i];
        for (int j = i;j < s.length();j++) {
            String str = s.substring(i, j + 1);

            if (isPalindrome(str)) {
                int cost = 1 + helper(j + 1,s,dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}


// tabulation

class Solution {
    static int palPartition(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1;i >= 0;i--){
            int minCost = Integer.MAX_VALUE;
            for (int j = i;j < n;j++){
                String str = s.substring(i,j + 1);
                if (isPalindrome(str)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0] - 1;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}