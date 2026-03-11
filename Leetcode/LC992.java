// modified sliding window approach
// if the question was to find the number of subarrays with sum equal to goal, we should use the formulas
// exact(goal) = exactly at most goal - exactly at most (goal - 1)
// simailar questions LC930
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int x = atmost(nums,k);
        int y = atmost(nums,k-1);
        return x-y;
    }
    private int atmost(int[] nums,int k){
        int n = nums.length;
        int i = 0,j=0;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k){
                 map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                 if(map.get(nums[i])==0) map.remove(nums[i]);
                 i++;
            }
            if(map.size()<= k) count = count + (j-i+1);
            j++;
        }
        return count;
    }
}