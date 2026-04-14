class Solution {
    String removeSpaces(String s) {
        StringBuilder str = new StringBuilder();
        for(char a : s.toCharArray()) if(a != ' ') str.append(a);
        return str.toString();
    }
}