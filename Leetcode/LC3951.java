import java.util.Arrays;

class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        long requiredBulbs = (brightness + 2) / 3;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        long totalDuration = 0;
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentEnd) {
                currentEnd = Math.max(currentEnd, intervals[i][1]);
            } else {
                totalDuration += (currentEnd - currentStart + 1);
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }
        }
        totalDuration += (currentEnd - currentStart + 1);
        return requiredBulbs * totalDuration;
    }
}