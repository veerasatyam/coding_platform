public class Solution {
    public int nchoc(int A, int[] B) {
        int mod = 1000000007;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int choco : B) {
            minHeap.add(-choco);
        }

        long total = 0;

        for (int i = 0; i < A; i++) {
            int maxChoco = -minHeap.poll();
            total = (total + maxChoco) % mod;
            minHeap.add(-(maxChoco / 2));
        }

        return (int) total;
    }
}
