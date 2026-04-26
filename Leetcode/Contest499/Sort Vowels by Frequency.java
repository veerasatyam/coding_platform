import java.util.*;

class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> firstIndex = new HashMap<>();
        for (int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (vowels.contains(ch)) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
                firstIndex.putIfAbsent(ch, i);
            }
        }
        List<Character> vowelList = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                vowelList.add(ch);
            }
        }
        vowelList.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            }
            return firstIndex.get(a) - firstIndex.get(b);
        });
        StringBuilder res = new StringBuilder();
        int idx = 0;
        for (char ch : s.toCharArray()) {
            if (!vowels.contains(ch)) {
                res.append(ch);
            } else {
                res.append(vowelList.get(idx++));
            }
        }
        return res.toString();
    }
}