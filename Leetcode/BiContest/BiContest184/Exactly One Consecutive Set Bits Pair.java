// You are given an integer n.

// Return true if its binary representation contains exactly one pair of consecutive set bits, and false otherwise.

// The set bits in an integer are the 1's present when it is written in binary.
 ©leetcode
class Solution {
    public boolean consecutiveSetBits(int n) {
        int count = 0;
        while (n > 1) {
            if ((n & 1) == 1 && ((n >> 1) & 1) == 1) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
            n >>= 1;
        }
        return count == 1;
    }
}