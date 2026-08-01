// brute force
class Solution {
    public int maximumWidth(int[] planks) {
       Arrays.sort(planks);
        int n = planks.length;
        HashSet<Long> heights = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j  < n; j++){
                heights.add((long)planks[i] + planks[j]);
            }
        }
        for(int i : planks) heights.add((long) i);
        int ans  = 0;
        for(long h : heights){
            int count = 0;
            List<Integer> remaining = new ArrayList<>();
            for(int p : planks){
                if(p == h){
                    count++;
                }else remaining.add(p);
            }
            Collections.sort(remaining);
            int i = 0;
            int j = remaining.size() - 1;
            while(i < j){
                long sum = (long) (remaining.get(i) + remaining.get(j));
                if(sum == h){
                    i++;j--;
                    count++;
                }else if(sum > h){
                    j--;
                }else i++;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}


// optimisation
class Solution {
    public int maximumWidth(int[] planks) {
        Arrays.sort(planks);
        int n = planks.length;
        HashMap<Long,Integer> freq = new HashMap<>();
        for (int x : planks) {
            long key = (long) x;
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        HashSet<Long> heights = new HashSet<>();
        for (int i = 0; i < n; i++) {
            heights.add((long) planks[i]);
            for (int j = i + 1; j < n; j++) {
                heights.add((long) planks[i] + (long) planks[j]);
            }
        }
        int ans = 0;
        for (long h : heights) {
            int width = 0;
            HashSet<Long> used = new HashSet<>();
            if (freq.containsKey(h)) {
                width += freq.get(h);
                used.add(h);
            }
            for (long x : freq.keySet()) {
                if (used.contains(x)) continue;
                long y = h - x;
                if (y <= 0) continue;
                if (freq.containsKey(y)) {
                    if (x == y) {
                        width += freq.get(x) / 2;
                        used.add(x);
                    } else if (!used.contains(y)) {
                        width += Math.min(freq.get(x), freq.get(y));
                        used.add(x);
                        used.add(y);
                    }
                }
            }
            ans = Math.max(ans,width);
        }

        return ans;
    }
}