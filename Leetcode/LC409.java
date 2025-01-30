
import java.util.HashSet;

class Solution {
    int count(char c,String s)
    {
        int n=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                n++;
            }
        }
        return n;
    }
    public int longestPalindrome(String s) {
        int counts=0;
        HashSet<Character> Set = new HashSet<>();
        for (char c : s.toCharArray()) {
            Set.add(c);
        }
        for(char x : Set)
        {
            int a = count(x,s);
            if(a%2==0) counts += a;
        }
        return counts;
    }
}