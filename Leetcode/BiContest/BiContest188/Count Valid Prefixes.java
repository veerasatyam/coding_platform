class Solution {
    public int countValidPrefixes(String s) {
        int count = 0;
        int diff = 0;
        for(char x : s.toCharArray()){
            diff += (x == '0') ? -1 : 1;
            if(Math.abs(diff) == 1 || diff == 0) count++;
        }
        return count;
    }
}