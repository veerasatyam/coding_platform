class Solution {
    public int findComplement(int num) {
        int All_ones = (1 << (Integer.toBinaryString(num).length())) - 1;
        return num ^ All_ones;
    }
}