class Solution {
    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) freq[num]++;
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (freq[i] == 1) sum += i;
        }
        return sum;
    }
}

// for space optimisation
// class Solution {
//     public int sumOfUnique(int[] nums) {
//         Arrays.sort(nums);
//         int sum = 0;
        
//         for (int i = 0; i < nums.length; ) {
//             int j = i + 1;
//             while (j < nums.length && nums[j] == nums[i]) {
//                 j++;
//             }
//             if (j == i + 1) { 
//                 sum += nums[i];
//             }
//             i = j;
//         }
        
//         return sum;
//     }
// }

