import java.util.*;

class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        helper(s, current, 0);
        return result;
    }

    void helper(String s, List<String> current, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                current.add(substring);     
                helper(s, current, i + 1);  
                current.remove(current.size() - 1); 
            }
        }
    }

    boolean isPalindrome(String x) {
        int i = 0, j = x.length() - 1;
        while (i < j) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
