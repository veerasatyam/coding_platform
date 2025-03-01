class Solution {
    public int numberOfChild(int n, int k) {
        int i = 0, direction = 1;
        while (k-- > 0) {
            i += direction;
            if (i == 0 || i == n - 1) {
                direction *= -1;
            }
        }
        return i;
    }
}
