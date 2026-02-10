class Solution {
    public int longestBalanced(int[] nums) {
        int max = 0;
        int n = nums.length;
        Set<Integer> odd = new HashSet<>();
        Set<Integer> even = new HashSet<>();
        for(int i = 0;i<n;i++){
            if(nums[i]%2==0) even.add(nums[i]);
            else odd.add(nums[i]);
            for(int j = i+1;j<n;j++){
                if(nums[j]%2==0) even.add(nums[j]);
                else odd.add(nums[j]);
                if(even.size() == odd.size()) max = Math.max(max,j-i+1);
            }
            even.clear();
            odd.clear();
        }
        return max;
    }
}