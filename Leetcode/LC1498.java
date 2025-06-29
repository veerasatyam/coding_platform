class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int left = 0, right = nums.length - 1;
        int[] pow = new int[nums.length];
        pow[0] = 1;

        for(int i = 1; i < nums.length; i++){
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        int count = 0;

        while(left <= right){
            if(nums[left] + nums[right] <= target){
                count = (count + pow[right - left]) % mod;
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}