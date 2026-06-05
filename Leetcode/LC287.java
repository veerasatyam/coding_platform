class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for(int a : nums){
            freq[a]++;
            if(freq[a] > 1) return a;
        }
        return -1;
    }
}


// expected O(n) time and O(1) space
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // First phase of Floyd's algorithm: Finding intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Second phase: Find entrance to the cycle
        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
