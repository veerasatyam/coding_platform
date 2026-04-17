class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(map.containsKey(nums[i])) min = Math.min(min,i - map.get(nums[i]));
            map.put(reverse(nums[i]),i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int reverse(int n){
        int result = 0;
        while(n > 0){
            int digit  = n % 10;
            result = result * 10 + digit;
            n /= 10;
        }
        return result;
    }
}