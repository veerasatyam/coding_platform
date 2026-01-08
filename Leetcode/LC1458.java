// pure recursion 
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        return helper(0,0,nums1,nums2);
    }
    private int helper(int i,int j,int[] nums1,int[] nums2){
        if(i==nums1.length || j== nums2.length) return Integer.MIN_VALUE/2;
        int take = nums1[i] * nums2[j];
        int next = helper(i + 1,j + 1,nums1,nums2);
        take = Math.max(take,take+next);
        int skip1 = helper(i+1,j,nums1,nums2);
        int skip2 = helper(i,j+1,nums1,nums2);
        return Math.max(take, Math.max(skip1, skip2));
    }
}

// recursion + memoization
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,0,nums1,nums2,dp);
    }
    private int helper(int i,int j,int[] nums1,int[] nums2,int[][] dp){
        if(i==nums1.length || j== nums2.length) return Integer.MIN_VALUE/2;
        if(dp[i][j] != -1) return dp[i][j];
        int take = nums1[i] * nums2[j];
        int next = helper(i + 1,j + 1,nums1,nums2,dp);
        take = Math.max(take,take+next);
        int skip1 = helper(i+1,j,nums1,nums2,dp);
        int skip2 = helper(i,j+1,nums1,nums2,dp);
        return dp[i][j] = Math.max(take, Math.max(skip1, skip2));
    }
}


// tabulation
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)dp[i][m] = Integer.MIN_VALUE/2;
        for(int j=0;j<=m;j++)dp[n][j] = Integer.MIN_VALUE/2;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int take = nums1[i] * nums2[j];
                int next = dp[i+1][j+1];
                take = Math.max(take,take+next);
                int skip1 = dp[i+1][j];
                int skip2 = dp[i][j+1];
                dp[i][j] = Math.max(take,Math.max(skip1,skip2));
            }
        }
        return dp[0][0];
    }
}