
import java.util.HashSet;

class Solution {
    public boolean isSubsequence(String s, String t) {
       HashSet<Character> hs = new HashSet<>();
       for(char a : s.toCharArray()) hs.add(a);
       String result = "";
       for(int i=0;i<t.length();i++)
       {
        char x = t.charAt(i);
        if(hs.contains(x)) result += x;
       }
       return t.contains(result);
    }
}