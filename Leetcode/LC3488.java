import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);
            if (list.size() == 1) {
                result.add(-1);
                continue;
            }
            int idx = Collections.binarySearch(list, q);
            int size = list.size();
            int left = list.get((idx - 1 + size) % size);
            int right = list.get((idx + 1) % size);
            int d1 = Math.abs(q - left);
            int d2 = Math.abs(q - right);
            int dist1 = Math.min(d1, n - d1);
            int dist2 = Math.min(d2, n - d2);
            result.add(Math.min(dist1, dist2));
        }

        return result;
    }
}