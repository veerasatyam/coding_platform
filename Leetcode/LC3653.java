class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        for(int[] q : queries){
            int idx = q[0];
            int r = q[1];
            int k = q[2];
            int val = q[3];
            while(idx <= r){
                nums[idx] =(int)((1L * nums[idx] * val) % (1000000007));
                idx += k;
            }
        }
        int result = 0;
        for(int a : nums) result =  result ^ a;
        return result;
    }
}