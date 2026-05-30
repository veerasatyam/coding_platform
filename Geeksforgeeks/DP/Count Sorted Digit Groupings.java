// pure recursion
class Solution {
    public int validGroups(String s) {
       return solve(s, 0, 0);
    }
    private int solve(String s, int idx, int prevSum) {
        if (idx == s.length()) return 1;
        int count = 0;
        int currSum = 0;
        for (int end = idx; end < s.length(); end++) {
            currSum += s.charAt(end) - '0';
            if (currSum >= prevSum) {
                count += solve(s, end + 1, currSum);
            }
        }
        return count;
    }
}


// memoization
class Solution {
    public int validGroups(String s) {
       return solve(s, 0, 0, new HashMap<>());
    }
    private static int solve(String s, int idx, int prevSum, Map<String, Integer> memo) {
        String key = idx + "," + prevSum;
        if (memo.containsKey(key)) return memo.get(key);
        if (idx == s.length()) return 1;
        int count = 0;
        int currSum = 0;
        for (int end = idx; end < s.length(); end++) {
            currSum += s.charAt(end) - '0';
            if (currSum >= prevSum) {
                count += solve(s, end + 1, currSum, memo);
            }
        }
        memo.put(key, count);
        return count;
    }
}



// using dp array
class Solution {
    public int validGroups(String s) {
        int n = s.length();
        int[][] dp = new int[n][sum(s) + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return
       solve(s, 0, 0, dp);
    }
    private static int solve(String s, int idx, int prevSum, int[][] dp) {
        if (idx == s.length()) return 1;
        if (dp[idx][prevSum] != -1) return dp[idx][prevSum];
        int count = 0;
        int currSum = 0;
        for (int end = idx; end < s.length(); end++) {
            currSum += s.charAt(end) - '0';
            if (currSum >= prevSum) {
                count += solve(s, end + 1, currSum, dp);
            }
        }
        return dp[idx][prevSum] = count;
    }
    private static int sum(String s) {
        int total = 0;
        for (char c : s.toCharArray()) {
            total += c - '0';
        }
        return total;
    }
}
