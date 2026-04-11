class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int min = 2*n + 1;
        for (List<Integer> lis : map.values()) {
            if (lis.size() >= 3) {
                for (int i = 2; i < lis.size(); i++) {
                    int dist = 2 * (lis.get(i) - lis.get(i - 2));
                    min = Math.min(min, dist);
                }
            }
        }
        return min == 2*n + 1 ? -1 : min;
    }
}