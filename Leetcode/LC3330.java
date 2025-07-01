class Solution {
    public int possibleStringCount(String word) {
       int count = 0;
        char prevChar = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == prevChar) {
                count++;
            } else {
                prevChar = c;
            }
        }
        return count + 1;
    }
}
