import java.util.*;

class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>());
        return ans;
    }

    void backtrack(int start, int target, int[] candidates, List<Integer> current) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;

            current.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, current);
            current.remove(current.size() - 1);
        }
    }
}
