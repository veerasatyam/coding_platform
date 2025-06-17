import java.util.PriorityQueue;

class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int n = arr.length;
        for (int i = 0; i < Math.min(n, k + 1); i++) {
            minheap.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minheap.peek();
            minheap.poll();
            minheap.add(arr[i]);
        }
        while (!minheap.isEmpty()) {
            arr[index++] = minheap.peek();
            minheap.poll();
        }
    }
}
