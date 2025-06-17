import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        HashMap<Integer, Integer> scoreToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            scoreToIndex.put(score[i], i);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int s : score) {
            minHeap.offer(-s);
        }

        int rank = 1;
        while (!minHeap.isEmpty()) {
            int negScore = minHeap.poll();
            int originalScore = -negScore;
            int index = scoreToIndex.get(originalScore);

            if (rank == 1) result[index] = "Gold Medal";
            else if (rank == 2) result[index] = "Silver Medal";
            else if (rank == 3) result[index] = "Bronze Medal";
            else result[index] = String.valueOf(rank);

            rank++;
        }

        return result;
    }
}
