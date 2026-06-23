class Solution {
    class Pair {
        int key;
        int value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int key : freqMap.keySet()) {
            minHeap.add(new Pair(key, freqMap.get(key)));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) result[index++] = minHeap.poll().key;
        return result;
    }
}