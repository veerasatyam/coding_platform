class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int[] result = {-1,-1};
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int sum = nums[i] + nums[j];
                if(sum == target && nums[i] > nums[j]){
                    int prod = nums[i] * nums[j];
                    if(prod > max){
                        result[0] = i;
                        result[1] = j;
                        max = prod;
                    }
                }
            }
        }
        return result;
    }
}