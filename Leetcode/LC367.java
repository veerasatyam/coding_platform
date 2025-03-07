class Solution {
    public boolean isPerfectSquare(int num) {
          if (num < 2) return true;

        int l = 1, r = num;
        while (l <= r) {
            int mid = (l+r)/2;
            long square = (long) mid * mid;
            if (square == num) return true;
             else if (square > num) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}