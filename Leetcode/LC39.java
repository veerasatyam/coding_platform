class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(0,candidates,target,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int idx ,int[] candidates,int target,int sum,List<Integer> current){
        if(sum == target){
            result.add(new ArrayList<>(current));
        }
        for(int i=idx;i<candidates.length;i++){
            if(sum + candidates[i] <= target){
                current.add(candidates[i]);
                sum = sum + candidates[i];
                backtrack(i,candidates,target,sum,current);
                sum = sum - candidates[i];
                current.remove(current.size() - 1);
            }
        }
    }
}

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(0,candidates,target,new ArrayList<>());
        return ans;
    }
    private void helper(int i,int[] candidates,int target,List<Integer> current){
        if(i == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(current));
            }
             return;
        }
        if(candidates[i] <= target){
            current.add(candidates[i]);
            helper(i,candidates,target - candidates[i],current);
            current.remove(current.size() - 1);
        }
        helper(i + 1,candidates,target,current);
    }
}