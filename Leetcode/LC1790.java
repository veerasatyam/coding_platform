import java.util.Arrays;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] r1 = s1.toCharArray();
        char[] r2 = s2.toCharArray();
        int count = 0;
        int x = -1, y = -1;

        for (int i = 0; i < r1.length; i++) {
            if (r1[i] != r2[i]) {
                count++;
                if (count == 1) x = i;
                else if (count == 2) y = i;
            }
        }

        if (count == 2) {
            char temp = r1[x];
            r1[x] = r1[y];
            r1[y] = temp;

            return Arrays.equals(r1, r2);
        }

        return count == 0;
    }
}
