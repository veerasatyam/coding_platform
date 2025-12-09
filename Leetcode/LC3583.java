class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> L = new HashMap<>();
        HashMap<Integer, Integer> R = new HashMap<>();
        for (int x : nums)R.put(x, R.getOrDefault(x,0)+1);
        int count = 0;
        for (int i = 0;i<nums.length;i++) {
            int curr = nums[i];
            R.put(curr,R.get(curr)-1);
            int target = curr*2;
            count += L.getOrDefault(target,0)*R.getOrDefault(target,0);
            L.put(curr,L.getOrDefault(curr,0)+1);
        }
        return count;
    }
}
