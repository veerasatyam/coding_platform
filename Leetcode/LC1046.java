import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll(); 

            if (y != x) {
                maxHeap.offer(y - x); 
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}


// class Solution {
//     public int lastStoneWeight(int[] stones) {
       
//        int n = stones.length;

//        while(n>1){
//         Arrays.sort(stones);
         
//           stones[n-2] = stones[n-1]-stones[n-2];
//           n--;
//        }
//        return stones[0];

//     }
// }