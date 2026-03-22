// brute force if you submit this code it will give TLE but it is the correct approach
class Solution {
    public long countGoodSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            for(int j = i;j<n;j++){
                set.add(nums[j]);
                sum = sum | nums[j];
                if(set.contains(sum)) count++;
            }
        }
        return count;
    }
}
