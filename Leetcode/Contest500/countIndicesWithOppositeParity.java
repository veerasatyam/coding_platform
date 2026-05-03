class Solution {
    public int[] countOppositeParity(int[] nums) {
        int even = 0;
        int odd = 0;
        for(int a : nums){
            if(a % 2 == 1) odd++;
            else even++;
        }
        int[] ans = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            if(nums[i] % 2 == 0){
                ans[i] = odd;
                even--;;
            }else{
                ans[i] = even;
                odd--;
            }
        }
        return ans;
    }
}