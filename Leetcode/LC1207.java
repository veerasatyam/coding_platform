class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        HashSet<Integer> seenFrequencies = new HashSet<>();
        
        for (int count : frequencyMap.values()) {
            if (!seenFrequencies.add(count)) {
                return false;
            }
        }
        
        return true;
    }
}