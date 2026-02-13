import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int maxL = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                maxL = Math.max(maxL, count);
                count = 1;
            }
        }
        maxL = Math.max(maxL, count);
        maxL = Math.max(maxL, helper(s, 'a', 'b'));
        maxL = Math.max(maxL, helper(s, 'a', 'c'));
        maxL = Math.max(maxL, helper(s, 'b', 'c'));
        int countA = 0;
        int countB = 0;
        int countC = 0;
        Map<String, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') countA++;
            if (ch == 'b') countB++;
            if (ch == 'c') countC++;
            if (countA == countB && countA == countC) {
                maxL = Math.max(maxL, countA + countB + countC);
            }
            int diffAB = countA - countB;
            int diffAC = countA - countC;
            String key = diffAB + "_" + diffAC;
            if (diffMap.containsKey(key)) {
                maxL = Math.max(maxL, i - diffMap.get(key));
            } else {
                diffMap.put(key, i);
            }
        }
        return maxL;
    }
    private int helper(String s, char ch1, char ch2) {
        int n = s.length();
        Map<Integer, Integer> diffMap = new HashMap<>();
        int maxL = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ch1 && s.charAt(i) != ch2) {
                diffMap.clear();
                count1 = 0;
                count2 = 0;
                continue;
            }
            if (s.charAt(i) == ch1)
                count1++;
            if (s.charAt(i) == ch2)
                count2++;
            if (count1 == count2) {
                maxL = Math.max(maxL, count1 + count2);
            }
            int diff = count1 - count2;
            if (diffMap.containsKey(diff)) {
                maxL = Math.max(maxL, i - diffMap.get(diff));
            } else {
                diffMap.put(diff, i);
            }
        }
        return maxL;
    }
}
