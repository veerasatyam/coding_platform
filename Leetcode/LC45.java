// pure recursion 
class Solution {
    public int jump(int[] nums) {
        return helper(0,nums,0);
    }
    private int helper(int i,int[] nums,int jumps) {
        if (i >= nums.length - 1)return jumps;
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= nums[i]; x++) {
            if (i + x < nums.length) {
                min = Math.min(min,helper(i + x,nums,jumps + 1));
            }
        }
        return min;
    }
}


// better recursion logic
class Solution {
    public int jump(int[] nums) {
        return helper(0, nums);
    }
    private int helper(int i,int[] nums) {
        if (i >= nums.length - 1)return 0;
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= nums[i]; x++) {
            if (i + x < nums.length) {
                int ans = helper(i + x, nums);
                if (ans != Integer.MAX_VALUE) min = Math.min(min,1 + ans);
            }
        }
        return min;
    }
}


// memoization 
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }
    private int helper(int i,int[] nums,int[] dp) {
        if (i >= nums.length - 1)return 0;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= nums[i]; x++) {
            if (i + x < nums.length) {
                int ans = helper(i + x,nums,dp);
                if (ans != Integer.MAX_VALUE) min = Math.min(min,1 + ans);
            }
        }
        return dp[i] = min;
    }
}

// tabulation 
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;
        for(int i = n-2;i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for (int x = 1; x <= nums[i]; x++) {
                if (i + x < nums.length) {
                    int ans = dp[i+x];
                    if (ans != Integer.MAX_VALUE) min = Math.min(min,1 + ans);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }
}



// space optimisation or greedy approach 
class Solution {
    public static int jump(int[] nums) {
        int farthest = 0;
        int jumps = 0;
        int curr = 0;
        for(int i=0;i<nums.length-1;i++){
            farthest = Math.max(farthest, nums[i] + i);
            if(i==curr){
                jumps++;
                curr = farthest;
            }

        }
        return jumps;
    }
}

