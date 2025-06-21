import java.util.*;

class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>());
        return ans;
    }

    void backtrack(int index, int[] nums, List<Integer> current) {
        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            backtrack(i + 1, nums, current);
            current.remove(current.size() - 1);
        }
    }
}
