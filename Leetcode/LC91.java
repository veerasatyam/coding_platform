class Solution {
    public int numDecodings(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        int ways = helper(s, i + 1);
        if (i < s.length() - 1) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num <= 26) ways += helper(s, i + 2);
        }
        return ways;
    }
}


// recursion + memoization
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0,dp);
    }

    private int helper(String s, int i,int[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int ways = helper(s, i + 1,dp);
        if (i < s.length() - 1) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num <= 26) ways += helper(s, i + 2,dp);
        }
        return dp[i] = ways;
    }
}


class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        int n =s.length();
        dp[s.length()] = 1;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0') continue;
            int ways = dp[i + 1];
            if (i < s.length() - 1) {
                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if (num <= 26) ways += dp[i + 2];
            }
            dp[i] = ways;
        }
        return dp[0];
    }
}


class Solution {
    public int numDecodings(String s) {
        int n =s.length();
        int second = 1;
        int first = s.charAt(n - 1) == '0' ? 0 : 1;
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '0') {
                second = first;
                first = 0;
                continue;
            }
            int ways = first;
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num <= 26) ways += second;
            second = first;
            first = ways;
        }
        return first;
    }
}
