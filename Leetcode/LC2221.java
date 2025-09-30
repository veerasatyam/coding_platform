class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        while(n>1){
            for(int i=0;i<n-1;i++){
                nums[i]=(nums[i]+nums[i+1])%10;
            }
            n--;
        }
        return nums[0];
    }
}

//optimised version using coeffiecent trick :

// class Solution {
//     public int triangularSum(int[] nums) {
//         int n = nums.length;
        
//         // This will hold the final answer
//         int result = 0;

//         // coeff represents the binomial coefficient C(n-1, i)
//         long coeff = 1; // Start with C(n-1, 0) = 1

//         // Loop through each number in the array
//         for (int i = 0; i < n; i++) {
            
//             // Add the contribution of nums[i] * C(n-1, i) to result
//             long contribution = coeff * nums[i];
//             result = (int)((result + contribution) % 10);

//             // Update coeff to the next binomial coefficient:
//             // C(n-1, i+1) = C(n-1, i) * (n-1-i) / (i+1)
//             if (i < n - 1) {
//                 coeff = coeff * (n - 1 - i) / (i + 1);
//             }
//         }

//         return result;
//     }
// }
