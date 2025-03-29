import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int currentPrefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentPrefixSum += num;
            
            if (prefixSumMap.containsKey(currentPrefixSum - k)) {
                count += prefixSumMap.get(currentPrefixSum - k);
            }
            
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }
        
        return count;
    }
}
