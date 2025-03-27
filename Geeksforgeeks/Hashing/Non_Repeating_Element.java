class Solution {
    public int firstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freqMap.get(num) == 1) {
                return num;
            }
        }
        return 0;
    }
}