class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for(String word: words) {
            int sum = 0;
            for(char c: word.toCharArray()) {
                sum += weights[c-'a'];
            }
            int charIndex =25 - sum%26;
            str.append((char)('a'+ charIndex));
        }
        return str.toString();
    }
}