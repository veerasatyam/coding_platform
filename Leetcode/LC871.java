import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, n = stations.length, refuelCount = 0;
        int currentFuel = startFuel;

        while (currentFuel < target) {
            while (i < n && stations[i][0] <= currentFuel) {
                maxHeap.offer(stations[i][1]);
                i++;
            }
            if (maxHeap.isEmpty()) {
                return -1;
            }
            currentFuel += maxHeap.poll();
            refuelCount++;
        }
        return refuelCount;
    }
}
