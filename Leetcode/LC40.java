class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0,candidates,target,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int idx ,int[] candidates,int target,int sum,List<Integer> current){
        if(sum == target){
            result.add(new ArrayList<>(current));
        }
        for(int i=idx;i<candidates.length;i++){
            if(i > idx && candidates[i]== candidates[i-1]) continue;
            if(sum + candidates[i] <= target){
                current.add(candidates[i]);
                sum = sum + candidates[i];
                backtrack(i+1,candidates,target,sum,current);
                sum = sum - candidates[i];
                current.remove(current.size() - 1);
            }
        }
    }
}


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates,int target,int index,List<Integer> current,List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;
        
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])continue;
            if (candidates[i] > target) break;
            current.add(candidates[i]);
            backtrack(candidates,target - candidates[i],i + 1,current,result);
            current.remove(current.size() - 1); 
        }
    }
}