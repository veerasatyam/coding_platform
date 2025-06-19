import java.util.*;

class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        collectSubsets(nums, 0, new ArrayList<>());
        return ans;
    }

    void collectSubsets(int[] nums, int index, List<Integer> current) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        collectSubsets(nums, index + 1, current);
        current.remove(current.size() - 1);
        collectSubsets(nums, index + 1, current);
    }
}
