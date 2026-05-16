class Solution {
    public int findSmallest(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        Boolean[][] dp = new Boolean[arr.length][sum + 1];
        for (int t = 0; t <= sum; t++)findDPTable(arr, 0, t, dp);
        for (int i = 1; i <= sum; i++)if (!dp[0][i]) return i;
        return sum + 1;
    }
    private boolean findDPTable(int[] arr,int i,int target,Boolean[][] dp){
        if (target == 0) return true;
        if (i >= arr.length) return false;
        if (dp[i][target] != null) return dp[i][target];
        boolean notTake = findDPTable(arr, i + 1, target, dp);
        boolean take = false;
        if (arr[i] <= target)take = findDPTable(arr,i + 1,target - arr[i],dp);
        return dp[i][target] = take || notTake;
    }
}


//expected dp approach but this will also shows TLE
class Solution {
    public int findSmallest(int[] arr) {
       int sum = 0;
        for (int val : arr) sum += val;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0;i < arr.length;i++) {
            for (int j = sum - arr[i];j >= 0;j--){
                if (dp[j]) dp[j + arr[i]] = true;
            }
        }
        for (int i = 0;i <= sum;i++)if (!dp[i]) return i;
        return sum + 1;
    }
}

// Actaul solution
class Solution {
    public int findSmallest(int[] arr) {
       Arrays.sort(arr);
       int res = 1;
       for(int i = 0;i<arr.length;i++){
          if(res < arr[i]) return res;
          res += arr[i];
       }
       return res;
    }
}