class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, h = 10000000, ans = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(mid, dist, hour)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int speed, int[] dist, double hour) {
        double totalTime = 0;

        for (int i = 0; i < dist.length; i++) {
            double time = (double) dist[i] / speed;
            totalTime += (i == dist.length - 1) ? time : Math.ceil(time);
            if (totalTime > hour) return false;
        }
        return totalTime <= hour;
    }
}
