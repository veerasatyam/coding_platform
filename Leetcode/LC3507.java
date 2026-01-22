class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for(int a : nums) ls.add(a);
        int count = 0;
        while(!isSorted(ls)){
            int n = ls.size();
            int sum = Integer.MAX_VALUE;
            int index = -1;
            for(int i=0;i<n-1;i++){
                int curr = ls.get(i) + ls.get(i+1);
                if(curr < sum){
                    sum = curr;
                    index = i;
                }
            }
            ls.set(index,sum);
            ls.remove(index+1);
            count++;
        }
        return count;
    }
    public boolean isSorted(List<Integer> ls){
        for(int i=0;i<ls.size()-1;i++){
            if(ls.get(i) > ls.get(i+1)) return false;
        }
        return true;
    }
}