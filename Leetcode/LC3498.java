class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int reverseAlphabetPosition = 26 - (s.charAt(i) - 'a');
            int stringPosition = i + 1;
            total += reverseAlphabetPosition * stringPosition;
        }
        
        return total;
    }
}