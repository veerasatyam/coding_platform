class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Integer[] dp = new Integer[n];
        return dfs(0, jobs, dp);
    }

    private int dfs(int i, int[][] jobs, Integer[] dp) {
        if (i == jobs.length) return 0;
        if (dp[i] != null) return dp[i];
        int next = lowerBound(jobs, jobs[i][1]);
        return dp[i] = Math.max(jobs[i][2] + dfs(next, jobs, dp),dfs(i + 1, jobs, dp));
    }
    private int lowerBound(int[][] jobs, int target) {
        int l = 0, r = jobs.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (jobs[m][0] < target) l = m + 1;
            else r = m;
        }
        return l;
    }
}