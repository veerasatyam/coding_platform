// S1 + S2 = S
// S1 - S2 = diff

// Adding both equations:

// S1 + S2 + S1 - S2 = S + diff
// 2*S1 = S + diff

// S1 = (S + diff) / 2

// pure recursion to count the subsets
class Solution {
    public int countPartitions(int[] arr, int diff) {
       int total = 0;
       for(int a : arr) total += a;
       int required = (total + diff) / 2;
       if((total + diff) % 2 != 0) return 0;
       return countSubsets(required,arr,0,0);
    }
    private int countSubsets(int sum,int[] arr,int i,int curr){
        if (i == arr.length)return curr == sum ? 1 : 0;
        if (curr > sum) return 0;
        int take = countSubsets(sum,arr,i+1,curr+arr[i]);
        int notTake = countSubsets(sum,arr,i+1,curr);
        return take + notTake;
    }
}


// recursion + memo 
class Solution {
    public int countPartitions(int[] arr, int diff) {
       int total = 0;
       for(int a : arr) total += a;
       int required = (total + diff) / 2;
       if((total + diff) % 2 != 0) return 0;
       int[][] dp = new int[arr.length + 1][required + 1];
       for(int[] row : dp) Arrays.fill(row,-1);
       return countSubsets(required,arr,0,0,dp);
    }
    private int countSubsets(int sum,int[] arr,int i,int curr,int[][] dp){
        if (i == arr.length)return curr == sum ? 1 : 0;
        if (curr > sum) return 0;
        if(dp[i][curr] != -1) return dp[i][curr];
        int take = countSubsets(sum,arr,i+1,curr+arr[i],dp);
        int notTake = countSubsets(sum,arr,i+1,curr,dp);
        return dp[i][curr] = take + notTake;
    }
}
