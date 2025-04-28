import java.util.HashMap;

class Solution {
    public String findValidPair(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char a : s.toCharArray()) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        
        for (int i = 1; i < s.length(); i++) {
            char a = s.charAt(i - 1);
            char b = s.charAt(i);
            if(a!=b)
            {
                if (Character.isDigit(a) && Character.isDigit(b)) {
                    if (hm.get(a) == a - '0' && hm.get(b) == b - '0') {
                        return "" + a + b;
                    }
                }
            }
        }
        return "";
    }
}
