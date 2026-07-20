class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        int divide = 5;
        while(n >= divide){
            count += n / divide;
            divide = divide * 5;
        }
        return count;
    }
}