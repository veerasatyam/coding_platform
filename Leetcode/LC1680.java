class Solution {
    public int concatenatedBinary(int n) {
        final int mod = 1000000007;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(Integer.toBinaryString(i));
        }
        long ans = 0;
        for(int i = 0; i < sb.length(); i++){
            ans = (ans * 2 + sb.charAt(i) - '0') % mod;
        }
        return (int)ans;
    }
}
// 1. Convert each number from 1 to n to binary and concatenate them into a string.
// 2. Iterate through the concatenated binary string and calculate the decimal value while taking modulo


// optimized solution without using StringBuilder
class Solution {
    public int concatenatedBinary(int n) {
        final int mod = 1000000007;
        long result = 0;
        int currBit = 0;
        for(int i = 1;i<=n;i++){
            if((i & (i-1))==0) currBit++;
            result = ((result<<currBit) | i) % mod;
        }
        return (int)result;
    }
}