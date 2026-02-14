class Solution {
    public int prefixConnected(String[] words, int k) {
        int n = words.length;
        int[] seen = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            seen[i] = 1;
            int x = 1;
            for(int j = i+1;j<n;j++){
                if(seen[j] == 0 && isConnected(words[i], words[j], k)){
                    seen[j] = 1;
                    x++;
                }
            }
            if(x>1) count++;
        }
        return count;
    }
    private boolean isConnected(String w1,String w2,int k){
        String prefix1 = w1.substring(0, Math.min(w1.length(), k));
        String prefix2 = w2.substring(0, Math.min(w2.length(), k));
        return prefix1.equals(prefix2);
    }
}




// another approach

class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (word.length() >= k) {
                String prefix = word.substring(0, k);
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        int count = 0;
        for (int value : map.values()) {
            if (value > 1)  count++;
        }
        return count;
    }
}
