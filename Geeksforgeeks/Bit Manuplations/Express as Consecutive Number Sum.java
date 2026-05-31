class Solution {
    public boolean isSumOfConsecutive(int n) {
        if((n & (n - 1)) == 0) return false;
        return true;
    }
}