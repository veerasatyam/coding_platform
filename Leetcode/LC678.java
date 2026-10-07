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


// Range based Appraoch 
// we know that if a * is present it can be used as ( or ) or empty string so we can keep track of the range of open brackets we can have at any point in time.
// we can keep track of the minimum and maximum number of open brackets we can have at any point in time. If at any point the maximum number of open brackets becomes negative, we can return false. At the end, if the minimum number of open brackets is zero, we can return true.
class Solution{
    public boolean checkValidString(String s){
        int max = 0;
        int min = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char x = s.charAt(i);
            if(x == '('){
                max++;
                min++;
            }else if(x == ')'){
                max--;
                min--;
            }else{
                max++;
                min--;
            }
            if(max < 0) return false;
            if(min < 0) min = 0;
        }
        return min == 0;
    }
}