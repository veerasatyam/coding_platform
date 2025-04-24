import java.util.HashMap;

class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxsize = -1;

        for (int i = 1; i <= n; i++) {
            int x = helper(i);
            hm.put(x, hm.getOrDefault(x, 0) + 1);
            maxsize = Math.max(maxsize, hm.get(x));
        }

        int count = 0;
        for (Integer a : hm.values()) {
            if (a == maxsize) count++;
        }

        return count;
    }

    private int helper(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
