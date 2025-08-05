import java.util.HashMap;

class Solution {
    public long subarrayXor(int[] arr, int k) {
        int res = 0;
        int prefixXor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            prefixXor ^= a;

            if (prefixXor == k) res++;

            res += map.getOrDefault(prefixXor ^ k, 0);
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return res;
    }
}
