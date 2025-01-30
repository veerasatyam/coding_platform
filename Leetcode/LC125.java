class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder filteredString = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredString.append(Character.toLowerCase(c));
            }
        }
        
        String original = filteredString.toString();
        String reversed = filteredString.reverse().toString();
        
        return original.equals(reversed);
    }
}
