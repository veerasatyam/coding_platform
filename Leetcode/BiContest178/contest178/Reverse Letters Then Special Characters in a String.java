class Solution {
    public String reverseByType(String s) {
        Stack<Character> letters = new Stack<>();
        Stack<Character> specials = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) letters.push(c);
            else specials.push(c);
        }
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))result.append(letters.pop()); 
            else result.append(specials.pop());
        }
        return result.toString();
    }
}