import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = findPairs(spells[i], potions, success);
        }
        return res;
    }

    private int findPairs(int s, int[] potions, long success) {
        int n = potions.length;
        long minPotionValue = (long) Math.ceil((double) success / s);

        int l = 0, r = n - 1, ans = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (potions[mid] >= minPotionValue) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return n - ans;
    }
}
