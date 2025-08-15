// class Solution {
//     public boolean isPowerOfFour(int n) {
//         while (n % 4 == 0 && n > 0) {
//             n = n / 4;
//         }
//         return n == 1;
//     }
// }

class Solution {
    public boolean isPowerOfFour(int n) {
       return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
