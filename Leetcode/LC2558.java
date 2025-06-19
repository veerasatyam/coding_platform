import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<gifts.length;i++) mh.add(gifts[i]);
        long total = 0;
        while(k-->0)
        {
            int a = (int)Math.sqrt(mh.poll());
            mh.add(a);
        }
        while(!mh.isEmpty()){
            total += mh.poll();
        }
        return total;
    }
}