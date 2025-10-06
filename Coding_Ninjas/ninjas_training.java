//pure recursion
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        return solve(n - 1, 3, points);
    }

    private static int solve(int day, int last, int[][] points) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) max = Math.max(max, points[0][task]);
            }
            return max;
        }

        int maxPoints = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int pointsToday = points[day][task] + solve(day - 1, task, points);
                maxPoints = Math.max(maxPoints, pointsToday);
            }
        }
        return maxPoints;
    }
}

// recursion+memorisation
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];  // last task: 0,1,2,3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) dp[i][j] = -1;
        }
        return solve(n - 1, 3, points, dp);
    }
    private static int solve(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) max = Math.max(max, points[0][task]);
            }
            return max;
        }
        if (dp[day][last] != -1) return dp[day][last];
        int maxPoints = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int pointsToday = points[day][task] + solve(day - 1, task, points, dp);
                maxPoints = Math.max(maxPoints, pointsToday);
            }
        }
        return dp[day][last] = maxPoints;
    }
}


//tabulation 
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int pointsToday = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], pointsToday);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }
}
