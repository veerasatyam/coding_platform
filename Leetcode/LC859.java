class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (m != n) return false;

        if (s.equals(goal)) {
            int[] frequency = new int[26];
            for (char c : s.toCharArray()) {
                frequency[c - 'a']++;
                if (frequency[c - 'a'] > 1) return true;
            }
            return false;
        }

        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (a == -1) a = i;
                else if (b == -1) b = i;
                else return false;
            }
        }

        return (b != -1 && s.charAt(a) == goal.charAt(b) && s.charAt(b) == goal.charAt(a));
    }
}
