
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int[] copied = Arrays.copyOf(nums, nums.length);
        List<Integer> numsList = new ArrayList<>();

        for (int num : nums)numsList.add(num);

        Collections.sort(numsList, (a, b) -> {
            int countA = getSum(a);
            int countB = getSum(b);

            if (countA != countB) {
                return Integer.compare(countA, countB);
            }
            return Integer.compare(a, b);
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(copied[i], i);
        }

        int minSwaps = 0;

        for (int i = 0; i < nums.length; i++) {
            if (copied[i] != numsList.get(i)) {
                minSwaps++;
                int index = map.get(numsList.get(i));
                map.put(copied[i], index);
                map.put(copied[index], i);
                int temp = copied[i];
                copied[i] = copied[index];
                copied[index] = temp;
                i--;
            }
        }

        return minSwaps;
    }

    private int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}



// using cycle detection in graph to find the minimum number of swaps required to sort the array based on the sum of digits and then by value. The algorithm first creates a sorted version of the input array based on the specified criteria, then uses a HashMap to track the original indices of the elements. It iterates through the array, and whenever it finds an element that is not in its correct position, it performs a swap and updates the mapping accordingly. The process continues until all elements are in their correct positions, counting the number of swaps made.


import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            int sumA = getSum(a[0]);
            int sumB = getSum(b[0]);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a[0], b[0]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][1] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][1];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }

    private int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
