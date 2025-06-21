import java.util.*;

class Solution {
    Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, digits, new StringBuilder());
        return result;
    }

    void backtrack(int index, String digits, StringBuilder path) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(index + 1, digits, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
