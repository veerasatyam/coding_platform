import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int a : nums) {
            hs.add(a);
        }
        return hs.size() != nums.length;
    }
}
