import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> href = new HashMap<>();
        for (char a : t.toCharArray()) {
            href.put(a, href.getOrDefault(a, 0) + 1);
        }
        
        int total = t.length();
        int i = 0, j = 0;
        int count = 0;
        HashMap<Character, Integer> ex = new HashMap<>();
        
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (j < s.length()) {
            char x = s.charAt(j);
            if (href.containsKey(x)) {
                ex.put(x, ex.getOrDefault(x, 0) + 1);
                if (ex.get(x) <= href.get(x)) {
                    count++;
                }
            }
            
            while (count == total) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    minStart = i;
                }
                
                char leftChar = s.charAt(i);
                if (href.containsKey(leftChar)) {
                    ex.put(leftChar, ex.get(leftChar) - 1);
                    if (ex.get(leftChar) < href.get(leftChar)) {
                        count--;
                    }
                }
                i++;
            }
            
            j++;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
