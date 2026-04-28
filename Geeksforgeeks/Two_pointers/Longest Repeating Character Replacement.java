class Solution {
    public int longestSubstr(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxFreq = 0, maxLen = 0;
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            if(j - i + 1 - maxFreq > k){
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                if(map.get(left) == 0) map.remove(left);
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}