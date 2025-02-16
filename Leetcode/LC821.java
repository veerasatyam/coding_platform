class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        int prev = -10000;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = Math.abs(i - prev);
        }

        prev = 10000;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = Math.min(answer[i], Math.abs(i - prev));
        }

        return answer;
    }
}
