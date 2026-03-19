import java.util.HashMap;

class Solution {
    public int countSubarray(int[] arr) {
        int count = 0;
        int sum = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < n; j++) {
            sum += (arr[j] == 1) ? 1 : -1;
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
