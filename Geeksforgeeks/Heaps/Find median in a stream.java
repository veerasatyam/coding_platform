import java.util.*;

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> ans = new ArrayList<>();
        PriorityQueue<Integer> b1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> b2 = new PriorityQueue<>(); 

        for (int num : arr) {
            if (b1.isEmpty() || num <= b1.peek()) {
                b1.add(num);
            } else {
                b2.add(num);
            }

            if (b1.size() > b2.size() + 1) {
                b2.add(b1.poll());
            } else if (b2.size() > b1.size()) {
                b1.add(b2.poll());
            }

            if ((b1.size() + b2.size()) % 2 == 0) {
                double median = ((double)b1.peek() + (double)b2.peek()) / 2.0;
                ans.add(median);
            } else {
                ans.add((double)b1.peek());
            }
        }

        return ans;
    }
}
