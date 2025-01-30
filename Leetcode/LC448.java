import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] seen = new boolean[nums.length + 1];
        
        for (int num : nums) {
            seen[num] = true;
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!seen[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}
