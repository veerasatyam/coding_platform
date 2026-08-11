// brute o(n) solution

import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return new int[][]{newInterval};
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
// optimal solution
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return new int[][]{newInterval};

        int newStart = newInterval[0], newEnd = newInterval[1];

        int L = n;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (intervals[mid][1] >= newStart) {
                L = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int R = -1;
        low = 0; high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (intervals[mid][0] <= newEnd) {
                R = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        List<int[]> res = new ArrayList<>();
        if (L > R) {
            for (int i = 0; i < L; i++) res.add(intervals[i]);
            res.add(newInterval);
            for (int i = L; i < n; i++) res.add(intervals[i]);
        } else {
            for (int i = 0; i < L; i++) res.add(intervals[i]);
            int start = Math.min(newStart, intervals[L][0]);
            int end = Math.max(newEnd, intervals[R][1]);
            res.add(new int[]{start, end});
            for (int i = R + 1; i < n; i++) res.add(intervals[i]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
