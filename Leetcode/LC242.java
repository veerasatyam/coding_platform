import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ns = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ns);
        Arrays.sort(ts);
        return Arrays.equals(ns, ts);
    }
}
