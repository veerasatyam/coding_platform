class Solution {
    public String findValidPair(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        for (int i=1;i<s.length();i++){
            if (s.charAt(i) != s.charAt(i-1) && freq.get(s.charAt(i)) == s.charAt(i)-'0' && freq.get(s.charAt(i-1)) == s.charAt(i-1)-'0'){
                return s.substring(i-1,i+1);
            }
        }
        return "";
    }
}