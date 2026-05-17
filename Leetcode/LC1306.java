// recursion
class Solution {
    boolean[] visited;
    public boolean canReach(int[] arr, int start){
        visited = new boolean[arr.length];
        return helper(arr,start);
    }
    private boolean helper(int[] arr,int i){
        if(i >= arr.length || i < 0) return false;
        if(visited[i]) return false;
        if(arr[i] == 0) return true;
        visited[i] = true;
        boolean left = helper(arr,i - arr[i]);
        boolean right = helper(arr,i + arr[i]);
        return left || right;
    }
}

// memoization
class Solution {
    boolean[] visited;
    public boolean canReach(int[] arr, int start){
        visited = new boolean[arr.length];
        Boolean[] dp = new Boolean[arr.length];
        return helper(arr,start,dp);
    }
    private boolean helper(int[] arr,int i,Boolean[] dp){
        if(i >= arr.length || i < 0) return false;
        if(visited[i]) return false;
        if(dp[i] != null) return dp[i]; 
        if(arr[i] == 0) return true;
        visited[i] = true;
        boolean left = helper(arr,i - arr[i],dp);
        boolean right = helper(arr,i + arr[i],dp);
        return dp[i] = left || right;
    }
}
