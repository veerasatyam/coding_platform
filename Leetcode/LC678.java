class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        return helper(s,0,0,dp);
    }
    private boolean helper(String s,int idx,int count,Boolean[][] dp){
        if(idx == s.length()){
            if(count == 0) return true;
            else return false;
        }
        if(count < 0) return false;
        if(dp[idx][count] != null) return dp[idx][count];
        if(s.charAt(idx) != '*'){
            if(s.charAt(idx) == '(') return dp[idx][count] = helper(s,idx+1,count+1,dp);
            else return dp[idx][count] = helper(s,idx + 1, count - 1,dp);
        }
        return dp[idx][count] = helper(s,idx + 1,count + 1,dp) || helper(s,idx + 1, count,dp) || helper(s,idx + 1, count - 1,dp);
    }
}