import java.util.HashSet;

class Solution {
    public String toGoatLatin(String sentence) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        String str = "a";

        for (String word : words) {
            char firstChar = word.charAt(0);
            if (vowels.contains(Character.toLowerCase(firstChar))) {
                result.append(word).append("ma").append(str);
            } else {
                result.append(word.substring(1)).append(firstChar).append("ma").append(str);
            }
            result.append(" ");
            str += "a";
        }

        return result.toString().trim();
    }
}
