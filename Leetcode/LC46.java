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




// another optimal solution
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(0,nums);
        return ans;
    }
    private void helper(int i,int[] nums){
        if(i == nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int x : nums) curr.add(x);
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int j = i; j < nums.length; j++){
            swap(j,i,nums);
            helper(i+1,nums);
            swap(i,j,nums);
        }
    }
    private void swap(int i,int j,int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}