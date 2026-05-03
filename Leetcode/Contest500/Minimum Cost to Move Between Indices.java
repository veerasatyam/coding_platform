class Solution {
    public int[] minCost(int[] nums, int[][] q) {
        int n = nums.length;
        int[] closest = new int[n];
        closest[0] = 1;
        closest[n-1] = n - 2;
        for(int i = 1;i <n-1;i++){
            int a = Math.abs(nums[i] - nums[i-1]);
            int b =  Math.abs(nums[i] - nums[i + 1]);
            if(a > b) closest[i] = i+1;
            else closest[i] = i-1;
        }
        int[] ans = new int[q.length];
        int[] forwardCost = new int[n];
        for(int i = 1;i<n;i++){
            if(closest[i-1] == i) forwardCost[i] = 1 + forwardCost[i-1];
            else forwardCost[i] = forwardCost[i-1] + Math.abs(nums[i-1] - nums[i]);
        }
        int[] backwardCost = new int[n];
        for(int i=n-2;i>=0;i--){
            if(closest[i+1] == i) backwardCost[i] = 1 + backwardCost[i+1];
            else backwardCost[i] = backwardCost[i+1] + Math.abs(nums[i+1] - nums[i]);
        }
        
        for(int i = 0;i<q.length;i++){
            int l = q[i][0];
            int r = q[i][1];
            if(r > l){
                ans[i] = Math.abs(forwardCost[r] - forwardCost[l]);
            }else{
                ans[i] = Math.abs(backwardCost[l] - backwardCost[r]);
            }
        }
        return ans;
    }
}