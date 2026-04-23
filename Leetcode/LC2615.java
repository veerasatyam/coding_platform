import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        long[] result = new long[n];
        for (List<Integer> lis : map.values()) {
            for (int idx : lis) {
                result[idx] = calculate(lis, idx);
            }
        }
        return result;
    }
    private long calculate(List<Integer> lis, int x) {
        long sum = 0;
        for (int a : lis) {
            sum += Math.abs(a - x);
        }
        return sum;
    }
}



// optimal solution 
import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for (List<Integer> list : map.values()) {
            int size = list.size();
            long prefixSum = 0;
            long totalSum = 0;
            for (int idx : list) totalSum += idx;
            for (int i = 0; i < size; i++) {
                int index = list.get(i);
                long left = (long) index * i - prefixSum;
                long right = (totalSum - prefixSum - index) - (long) index*(size - i - 1);
                result[index] = left + right;
                prefixSum += index;
            }
        }
        return result;
    }
}