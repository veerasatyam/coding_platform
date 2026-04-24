class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') l++;
            else if (c == 'R') r++;
        }
        int blanks = moves.length() - (l + r);
        return Math.abs(l - r) + blanks;
    }
}