class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA != freqB) {
                return freqB - freqA;
            }
            return a.compareTo(b);
        });

        pq.addAll(map.keySet());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
           result.add(pq.poll());
        }
        return result;
    }
}