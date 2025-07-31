import java.util.HashSet;

class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int n = s.length();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) count++;
        }
        int max = count;
        for (int i = k; i < n; i++) {
            if (vowels.contains(s.charAt(i))) count++;
            if (vowels.contains(s.charAt(i - k))) count--;
            max = Math.max(max, count);
        }

        return max;
    }
}
