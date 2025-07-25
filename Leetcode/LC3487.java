import java.util.HashSet;

class Solution {
    public int maxSum(int[] nums) {
        int sum = 0,n=nums.length;
        int max = Integer.MIN_VALUE;
        for(int a : nums) max = Math.max(max,a);
        if(max<=0) return max;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
             if(nums[i]>0 && !set.contains(nums[i])){
                sum = sum + nums[i];
                set.add(nums[i]);
             }
        }
        return sum;
    }
}