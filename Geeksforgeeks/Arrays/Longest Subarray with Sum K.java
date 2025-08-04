import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) res = i + 1;
            else if (map.containsKey(sum - k)) res = Math.max(res, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }

        return res;
    }
}
