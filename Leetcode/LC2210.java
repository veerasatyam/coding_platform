class Solution {
    public int countHillValley(int[] nums) {
        int i = 1;
        int n = nums.length;
        int count = 0;

        while (i <= n - 2) {
            int x = nums[i];
            int y = i - 1;
            int z = i + 1;

            while (y >= 0 && nums[y] == x)  y--;
            while (z < n && nums[z] == x)   z++;
            if (y >= 0 && z < n) {
                if (x > nums[y] && x > nums[z]) count++;
                else if (x < nums[y] && x < nums[z]) count++;
            }
            i = z;
        }
        return count;
    }
}