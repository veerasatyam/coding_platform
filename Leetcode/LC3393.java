import java.util.HashSet;

class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;
        int currentPos = 0;
        
        while (currentPos < n) {
            HashSet<Integer> currentSet = new HashSet<>();
            boolean duplicateFound = false;
            int checkPos = currentPos;
            
            while (checkPos < n) {
                if (currentSet.contains(nums[checkPos])) {
                    duplicateFound = true;
                    break;
                }
                currentSet.add(nums[checkPos]);
                checkPos++;
            }
            
            if (!duplicateFound) break;
            
            operations++;
            currentPos += 3;
        }
        
        return operations;
    }
}