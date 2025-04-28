import java.util.HashSet;

class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int a : nums)
        {
            if(a!=0) hs.add(a);
        }
        return hs.size();
    }
}