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