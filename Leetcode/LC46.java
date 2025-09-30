import java.util.ArrayList;
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generate(nums,used,curr);
        return result;
    }

    private void generate(int[] nums,boolean[] used,ArrayList<Integer> curr){
        if(curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            curr.add(nums[i]);
            used[i]=true;
            generate(nums,used,curr);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}