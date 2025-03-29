import java.util.HashMap;

class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        int ans = -1;
        for (Integer k : hm.keySet()) {
            if (hm.get(k) == k) {
                ans = Math.max(ans, k);
            }
        }
        
        return ans;
    }
}
