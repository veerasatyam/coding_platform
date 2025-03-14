class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int zero_count = 0, max = 0;
        
        while (j < nums.length) {
            if (nums[j] == 0) {
                zero_count++;
            }

            while (zero_count > k) {
                if (nums[i] == 0) {
                    zero_count--;
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
            
            j++;
        }
        
        return max;
    }
}
