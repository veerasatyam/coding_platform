// recusive solution but shows TLE
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        return helper(0, 0, 0, nums1, nums2);
    }
    private int helper(int i, int j, int count, int[] n1, int[] n2) {
        if (i >= n1.length || j >= n2.length) return count;
        int c = count;
        if (n1[i] == n2[j])c = helper(i + 1,j + 1,count + 1,n1,n2);
        int t1 = helper(i + 1,j,0,n1,n2);
        int t2 = helper(i,j + 1,0,n1,n2);
        return Math.max(c, Math.max(t1, t2));
    }
}

// memorization but shows MLE
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][][] dp = new int[nums1.length + 1][nums2.length + 1][Math.min(nums1.length,nums2.length) + 1];
        for(int[][] mat : dp){
            for(int[] row : dp) Arrays.fill(row,-1);
        }
        return helper(0, 0, 0, nums1, nums2,dp);
    }
    private int helper(int i, int j, int count, int[] n1, int[] n2,int[][][] dp){
        if (i >= n1.length || j >= n2.length) return count;
        if(dp[i][j][count != -1]) return dp[i][j][count];
        int c = count;
        if (n1[i] == n2[j])c = helper(i + 1,j + 1,count + 1,n1,n2,dp);
        int t1 = helper(i + 1,j,0,n1,n2,dp);
        int t2 = helper(i,j + 1,0,n1,n2,dp);
        return dp[i][j][count] = Math.max(c, Math.max(t1, t2));
    }
}


// optimal solution 
class Solution {
    int[][] dp;
    int max = 0;

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Try every starting pair
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                helper(i, j, nums1, nums2);
            }
        }

        return max;
    }

    private int helper(int i, int j, int[] n1, int[] n2) {
        if (i >= n1.length || j >= n2.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        if (n1[i] == n2[j]) {
            ans = 1 + helper(i + 1, j + 1, n1, n2);
            max = Math.max(max, ans);
        }

        // Important: still explore other pairs
        helper(i + 1, j, n1, n2);
        helper(i, j + 1, n1, n2);

        return dp[i][j] = ans;
    }
}



// final solution 
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}


