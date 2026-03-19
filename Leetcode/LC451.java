class Solution {
    class EandF{
        char e;
        int freq;
        EandF(char e,int freq){
            this.e = e;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char a : s.toCharArray()) map.put(a,map.getOrDefault(a,0)+1);
         PriorityQueue<EandF> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq );
        for(char x : map.keySet()){
            pq.add(new EandF(x,map.get(x)));
        }
        StringBuilder str = new StringBuilder();
        while (!pq.isEmpty()) {
            EandF curr = pq.poll();
            for(int i =0;i<curr.freq;i++) str.append(curr.e);
        }
        return str.toString();
    }
}