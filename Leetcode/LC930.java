// modified sliding window approach
// if the question was to find the number of subarrays with sum equal to goal, we should use the formulas
// exact(goal) = exactly at most goal - exactly at most (goal - 1)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int x = atmost(nums, goal); 
        int y = atmost(nums, goal - 1); 
        return x - y; 
    }

    private int atmost(int[] nums, int goal) {
        if (goal < 0) return 0; 
        int x = 0; 
        int i = 0, j = 0; 
        int n = nums.length;
        int currSum = 0;
        while (j < n) {
            currSum += nums[j]; 
            while (currSum > goal) { 
                currSum -= nums[i];
                i++;
            }
            x += (j - i + 1); 
            j++;
        }
        return x;
    }
}