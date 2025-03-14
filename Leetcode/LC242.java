// import java.util.Arrays;

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         char[] ns = s.toCharArray();
//         char[] ts = t.toCharArray();
//         Arrays.sort(ns);
//         Arrays.sort(ts);
//         return Arrays.equals(ns, ts);
//     }
// }

import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> href = new HashMap<>();
        for (char x : s.toCharArray()) href.put(x, href.getOrDefault(x, 0) + 1);
            
        for (char x : t.toCharArray()) {
            if (!href.containsKey(x) || href.get(x) == 0) {
                return false; 
            }
            href.put(x, href.get(x) - 1); 
        }

        return true;  
    }
}

