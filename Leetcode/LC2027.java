class Solution {
    public int minimumMoves(String s) {
        int moves = 0;
        int i = 0;
        int n = s.length();
        while (i < n) {
            if (s.charAt(i) == 'X') {
                moves++;
                i += 3;
            } else {
                i++;
            }
        }
        return moves;
    }
}
