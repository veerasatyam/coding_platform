//brute force approach

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}


// optimized approach using HashMap to store prefix sums
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
