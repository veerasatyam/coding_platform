import java.util.Arrays;

class Solution {
    static boolean canAttend(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int lastEnd = -1;
        for (int[] meeting : arr) {
            int start = meeting[0];
            int end = meeting[1];
            if (lastEnd > start) {
                return false;
            }
            lastEnd = end;
        }
        return true;
    }
}