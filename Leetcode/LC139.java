class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return helper(0, s, dict);
    }
    private boolean helper(int index,String s,Set<String> dict) {
        if (index == s.length())return true;
        for (int i = index;i < s.length();i++) {
            String curr = s.substring(index, i + 1);
            if (dict.contains(curr)){
                if(helper(i + 1, s, dict))return true;
            }
        }
        return false;
    }
}

// memorization 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, s, dict,dp);
    }
    private boolean helper(int index,String s,Set<String> dict,Boolean[] dp) {
        if (index == s.length())return true;
        if(dp[index] != null) return dp[index];
        for (int i = index;i < s.length();i++) {
            String curr = s.substring(index, i + 1);
            if (dict.contains(curr)){
                if (helper(i + 1, s, dict,dp))return true;
            }
        }
        return dp[index] = false;
    }
}

// tabualtion
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int j = s.length() - 1;j >= 0;j--) {
            for (int i = j;i < s.length();i++) {
                String curr = s.substring(j, i + 1);
                if (dict.contains(curr) && dp[i + 1]) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}