class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            int curr = 0;
            while(i<n && nums[i]==1){
                curr++;
                i++;
            }
            ans = Math.max(curr, ans);
        }
        return ans;
    }
}