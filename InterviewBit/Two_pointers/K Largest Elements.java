public class Solution {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i<n;i++) heap.add(A[i]);
        while(heap.size()>B) heap.poll();
        int[] result = new int[B];
        for(int i=0;i<B;i++) result[i]=heap.poll();
        return result;
    }
}
