import java.util.*;

class Solution {
    public List<Integer> closestPairSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        List<Integer> closestPair = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            int currentDiff = Math.abs(currentSum - target);

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                closestPair.clear();
                closestPair.add(arr[left]);
                closestPair.add(arr[right]);
            } else if (currentDiff == minDiff) {
                int currentAbsDiff = Math.abs(arr[left] - arr[right]);
                int closestAbsDiff = Math.abs(closestPair.get(0) - closestPair.get(1));
                if (currentAbsDiff > closestAbsDiff) {
                    closestPair.clear();
                    closestPair.add(arr[left]);
                    closestPair.add(arr[right]);
                }
            }

            if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return closestPair;
    }
}