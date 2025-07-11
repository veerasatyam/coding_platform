import java.util.*;

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] visits = new int[n + 1];
        visits[rounds[0]]++;

        for (int i = 1; i < rounds.length; i++) {
            int start = rounds[i - 1];
            int end = rounds[i];

            while (start != end) {
                start = start % n + 1;
                visits[start]++;
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, visits[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (visits[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
