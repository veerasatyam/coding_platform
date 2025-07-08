import java.util.HashSet;

class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0, j = s.length() - 1;

        HashSet<Character> set = new HashSet<>();
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');

        while (i < j) {
            while (i < j && !set.contains(s.charAt(i))) {
                i++;
            }
            while (i < j && !set.contains(s.charAt(j))) {
                j--;
            }

            // Swap vowels
            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);

            i++;
            j--;
        }

        return str.toString();
    }
}
