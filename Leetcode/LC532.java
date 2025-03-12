import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        if (k == 0) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            int count = 0;
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
            for (int value : freqMap.values()) {
                if (value > 1) {
                    count++;
                }
            }
            return count;
        }

        Arrays.sort(nums);
        int p1 = 0, p2 = 1;
        int count = 0;

        while (p2 < nums.length) {
            int diff = nums[p2] - nums[p1];
            if (diff == k) {
                count++;
                p1++;
                p2++;
                while (p1 < nums.length && nums[p1] == nums[p1 - 1]) p1++;
                while (p2 < nums.length && nums[p2] == nums[p2 - 1]) p2++;
            } else if (diff < k) {
                p2++;
            } else {
                p1++;
                if (p1 == p2) p2++;
            }
        }
        return count;
    }
}
