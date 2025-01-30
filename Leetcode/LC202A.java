import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> saw = new HashSet<>();
        while(n != 1) {
            if(saw.contains(n)) return false;
            saw.add(n);
            n = sumOfSquaresOfDigits(n);
        }
        return true;
    }
    
    int sumOfSquaresOfDigits(int x) {
        int rem, sum = 0;
        while(x > 0) {
            rem = x % 10;
            sum += rem * rem;
            x = x / 10;
        }
        return sum;
    }
}
