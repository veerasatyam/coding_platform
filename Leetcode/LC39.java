import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        generate(0, target, candidates, list);
        return ans;
    }

    void generate(int i, int target, int[] candidates, ArrayList<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i >= candidates.length || target < 0) {
            return;
        }
        list.add(candidates[i]);
        generate(i, target - candidates[i], candidates, list);
        list.remove(list.size() - 1);
        generate(i + 1, target, candidates, list);
    }
}
