// pure recursion 
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(0,k,arr);
    }
    private int helper(int i,int k,int[] arr){
        if(i==arr.length) return 0;
        int length = 0;
        int max = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int ind=i;ind<(Math.min(arr.length,i+k));ind++){
            length++;
            max = Math.max(max,arr[ind]);
            int sum = max*length + helper(ind + 1,k,arr);
            maxAns = Math.max(sum,maxAns);
        }
        return maxAns;
    }
}

// memoization

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp =  new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(0,k,arr,dp);
    }
    private int helper(int i,int k,int[] arr,int[] dp){
        if(i==arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int length = 0;
        int max = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int ind=i;ind<(Math.min(arr.length,i+k));ind++){
            length++;
            max = Math.max(max,arr[ind]);
            int sum = max*length + helper(ind + 1,k,arr,dp);
            maxAns = Math.max(sum,maxAns);
        }
        return dp[i] = maxAns;
    }
}


// tabulation 

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp =  new int[arr.length+1];
        int n = arr.length;
        for(int i = n-1;i>=0;i--){
            int length = 0;
            int max = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            for(int ind=i;ind<(Math.min(n,i+k));ind++){
                length++;
                max = Math.max(max,arr[ind]);
                int sum = max*length + dp[ind+1];
                maxAns = Math.max(sum,maxAns);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
}