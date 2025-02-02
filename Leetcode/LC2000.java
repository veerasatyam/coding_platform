class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder result = new StringBuilder();
        int x = word.indexOf(ch);
        result.append(word.substring(0,x+1)).reverse();
        result.append(word.substring(x+1));
        return result.toString();
    }
}