class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length();
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            // odd-length palindrome
            int left = i, right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }

            // even-length palindrome
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, end + 1);
    }
}



// using recursion
class Solution {
    public String longestPalindrome(String s) {
        return helper(s,0,s.length() - 1);
    }
    private String helper(String str,int start,int end){
        if(start > end) return "";
        if(isPalindrome(str,start,end)){
            return str;
        }
        String left = helper(str,left+1,end);
        String right = helper(str,left,end - 1);
        return (left.length() > right.length()) ? left : right;
    }
    private boolean isPalindrome(String s,int start,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}


// recursion + memoiation 
class Solution {
    public String longestPalindrome(String s) {
        String[][] dp = new String[s.length()][s.length()];
        return helper(s,0,s.length() - 1,dp);
    }
    private String helper(String str,int start,int end,String[][] dp){
        if(start > end) return "";
        if(dp[start][end] != null) return dp[start][end];
        if(isPalindrome(str,start,end)) return dp[start][end] = str.substring(start,end + 1);
        String left = helper(str,start+1,end,dp);
        String right = helper(str,start,end - 1,dp);
        return dp[start][end] = (left.length() > right.length()) ? left : right;
    }
    private boolean isPalindrome(String s,int start,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}