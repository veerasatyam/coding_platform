class Solution {
    public long repairCars(int[] ranks, int cars) {
        long max = 0;
        for (int rank : ranks) {
            long time = (long) rank * cars * cars; 
            max = Math.max(time, max);
        }
        
        long l = 1, h = max;
        long ans = max;
        while (l <= h) {
            long mid = (l + h) / 2;
            if (can_repair(ranks, cars, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean can_repair(int[] ranks, int cars, long mid) {
        long totalCars = 0;
        for (int rank : ranks) {
            long timeForOneCar = rank;
            long left = 0, right = cars;
            while (left <= right) {
                long midCars = left + (right - left) / 2;
                long totalTime = timeForOneCar * midCars * midCars;
                if (totalTime <= mid) {
                    left = midCars + 1;
                } else {
                    right = midCars - 1;
                }
            }
            totalCars += right;
        }
        return totalCars >= cars;
    }
}