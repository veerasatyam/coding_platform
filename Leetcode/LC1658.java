class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0,tot=0,min=Integer.MIN_VALUE,l=0;
        for(int i:nums)
        tot+=i;
        int target=tot-x;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>target&&l<=i)
            sum-=nums[l++];    
            if(sum==target)
            min=Math.max(min,i-l+1);
        }
        return min==Integer.MIN_VALUE?-1:nums.length-min;
    }
}





class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int a : nums) sum += a;
        int target = sum - x;
        if(target == 0) return nums.length;
        int maxSubarry = helper(nums,target);
        if(maxSubarry == -1) return -1;
        return nums.length - maxSubarry;
    }
    private int helper(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int max = -1;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target && left <= right) sum -= nums[left++];
            if (sum == target) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}



// if nums contains negative numbers, we can use prefix sum and hashmap to solve this problem
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int a : nums) sum += a;
        int target = sum - x;
        if(target == 0) return nums.length;
        int maxSubarry = helper(nums,target);
        if(maxSubarry == -1) return -1;
        return nums.length - maxSubarry;
    }
    private int helper(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        if(target < 0) return -1;
        int max = Integer.MIN_VALUE;
        int prefixSum = 0;
        map.put(0,-1);
        for(int i = 0;i<nums.length;i++){
            prefixSum += nums[i];
            int find = prefixSum - target;
            if(map.containsKey(find)){
                int x = map.get(find) + 1;
                int y = i;
                max = Math.max(max,y - x + 1);
            }
            map.putIfAbsent(prefixSum,i);
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
