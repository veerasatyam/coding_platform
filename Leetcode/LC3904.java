class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        int[] lr = new int[n];
        for(int i = 0; i < n; i++){
            max = Math.max(max,nums[i]);
            lr[i] = max;
        }
        int min = nums[n - 1];
        int[] rl = new int[n];
        for(int i = n - 1; i >= 0; i--){
            min = Math.min(min,nums[i]);
            rl[i] = min;
        }
        int idx = -1;
        for(int i = 0; i < n; i++){
            if((lr[i] - rl[i]) <= k){
                idx = i;
                break;
            }
        }
        return idx;
    }
}