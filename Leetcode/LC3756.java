// // brute force  this apporach will not work shows TLE
// class Solution {
//     final int mod = 1000000007;
//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int size = queries.length;
//         int[] ans = new int[size];
//         for (int i = 0;i < size;i++) {
//             int start = queries[i][0];
//             int end = queries[i][1];
//             ans[i] = helper(s.substring(start,end + 1));
//         }
//         return ans;
//     }
//     private int helper(String str) {
//         long num = 0;
//         int sum = 0;
//         for (char c : str.toCharArray()) {
//             if (c != '0') {
//                 int digit = c - '0';
//                 sum += digit;
//                 num = (num * 10 + digit) % mod;
//             }
//         }
//         return (int) ((num * sum) % mod);
//     }
// }