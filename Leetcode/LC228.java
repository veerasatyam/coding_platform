class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int count = 1;
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
                count++;
            }
            if (count > 1) {
                String x = start + "->" + nums[i];
                list.add(x);
            } else {
                list.add(Integer.toString(nums[i]));
            }
        }
        return list;
    }
}
