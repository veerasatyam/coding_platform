//pure recursion 

class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1,word2,word1.length()-1,word2.length()-1);
    }
    private int helper(String word1,String word2,int i,int j){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(word1.charAt(i)==word2.charAt(j)) return helper(word1,word2,i-1,j-1);
        else return Math.min(1+helper(word1,word2,i-1,j),Math.min(1+helper(word1,word2,i,j-1),1+helper(word1,word2,i-1,j-1)));
    }
}


// recursion + memoization 

//pure recursion 

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    private int helper(String word1,String word2,int i,int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) return dp[i][j] = helper(word1,word2,i-1,j-1,dp);
        else return dp[i][j] = Math.min(1+helper(word1,word2,i-1,j,dp),Math.min(1+helper(word1,word2,i,j-1,dp),1+helper(word1,word2,i-1,j-1,dp)));
    }
}


//tabulation 

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min( dp[i - 1][j],Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        return dp[n][m];
    }
}


//space optimization using two 1-d arrays 

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        for (int j = 0; j <= m; j++) prev[j] = j;
        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    curr[j] = prev[j - 1];
                else
                    curr[j] = 1 + Math.min(
                        prev[j], 
                        Math.min(curr[j - 1], prev[j - 1])
                    );
            }
            prev = curr.clone();
        }

        return prev[m];
    }
}
