import java.util.PriorityQueue;

class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : arr) {
            heap.add(num);
        }
        int sum = 0;
        while (heap.size() > 1) {
            int m1 = heap.poll();
            int m2 = heap.poll();
            int cost = m1 + m2;
            sum += cost;
            heap.add(cost);
        }
        return sum;
    }
}
