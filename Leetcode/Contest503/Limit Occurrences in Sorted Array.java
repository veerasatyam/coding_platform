class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int currentNum = nums[i];
            int count = 0;
            while (i < nums.length && nums[i] == currentNum) {
                if (count < k) {
                    list.add(currentNum);
                }
                count++;
                i++;
            }
        }
        int[] ans = new int[list.size()];
        for (int m = 0;m < ans.length;m++) {
            ans[m] = list.get(m);
        }
        return ans;
    }
}