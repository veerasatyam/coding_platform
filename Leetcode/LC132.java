// recursion 

class Solution {
    public int minCut(String s) {
        return helper(0,s);
    }
    private int helper(int i,String s){
        if(i==s.length()) return 0;
        String temp = "";
        int min = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            temp += s.charAt(j);
            if(isPalindrome(temp)){
                min = Math.min(min,1 + helper(j+1,s));
            }
        }
        return min;
    }
    private boolean isPalindrome(String s){
        int i=0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}


// memoization

class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0,s,dp) - 1;
    }
    private int helper(int i,String s,int[] dp){
        if(i==s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        String temp = "";
        int min = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            temp += s.charAt(j);
            if(isPalindrome(temp)){
                int cuts = 1 + helper(j+1,s,dp);
                min = Math.min(min, cuts);
            }
        }
        dp[i] = min;
        return dp[i];
    }
    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}


// tabulation

class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            String temp = "";
            int min = Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
                temp += s.charAt(j);
                if(isPalindrome(temp)){
                    int cuts = 1 + dp[j+1];
                    min = Math.min(min, cuts);
                }
            }
            dp[i] = min;
        }
        return dp[0]-1;
    }
    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}