class Solution {
    class EandF{
        int e;
        int freq;
        EandF(int e,int freq){
            this.e = e;
            this.freq = freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int a : nums) map.put(a,map.getOrDefault(a,0)+1);
         PriorityQueue<EandF> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq != b.freq) {
                    return a.freq - b.freq;  
                } else {
                    return b.e - a.e; 
                }
            }
        );
        for(int x : map.keySet()){
            pq.add(new EandF(x,map.get(x)));
        }
        int[] result = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty()) {
            EandF curr = pq.poll();
            for (int i = 0; i < curr.freq; i++) {
                result[index++] = curr.e;
            }
        }
        return result;
    }
}