class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1; 
        int currentLineWidth = 0;

        for (char c : s.toCharArray()) {
            int charWidth = widths[c - 'a'];
            if (currentLineWidth + charWidth > 100) {
                lines++;
                currentLineWidth = charWidth;
            } else {
                currentLineWidth += charWidth;
            }
        }
        return new int[]{lines, currentLineWidth};
    }
}