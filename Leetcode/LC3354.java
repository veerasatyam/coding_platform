class Solution {
    public int countValidSelections(int[] nums) {
        int nonZeros = 0;
        for (int a : nums) if (a > 0) nonZeros++;
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (isValid(nums, i, 1, nonZeros)) count++;
                if (isValid(nums, i, -1, nonZeros)) count++;
            }
        }
        return count;
    }

    private boolean isValid(int[] nums, int start, int direction, int nonZeros) {
        int[] arr = nums.clone();
        int curr = start + direction;
        int n = arr.length;

        while (nonZeros > 0 && curr >= 0 && curr < n) {
            if (arr[curr] > 0) {
                arr[curr]--;
                if (arr[curr] == 0) nonZeros--;
                direction *= -1;
            }
            curr += direction;
        }
        return nonZeros == 0;
    }
}





//optimal version using prefix sum...

class Solution {
    public int countValidSelections(int[] nums) {

        int count = 0, len = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        int currSum = 0;
        for (int i = 0; i < len; i++) {
            currSum += nums[i];
            if (nums[i] == 0) {
                if (sum - currSum == currSum) count += 2;
                else if (Math.abs(sum - 2*currSum) == 1) count++; 
            }
        }
        return count;
    }
}