class Solution {
    public int findSubarray(int[] arr) {
       HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int currentPrefixSum = 0;
        int count = 0;
        
        for (int num : arr) {
            currentPrefixSum += num;
            
            if (prefixSumMap.containsKey(currentPrefixSum)) {
                count += prefixSumMap.get(currentPrefixSum);
            }
            
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }
        
        return count;
    }
}
