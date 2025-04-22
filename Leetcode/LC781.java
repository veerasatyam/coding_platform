import java.util.HashMap;

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int a : answers) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }

        int count = 0;
        for (int x : hm.keySet()) {
            int groupSize = x + 1;
            int numRabbits = hm.get(x);
            int groups = (int) Math.ceil((double) numRabbits / groupSize);
            count += groups * groupSize;
        }
        return count;
    }
}
