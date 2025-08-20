class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0;
        int[] freq = new int[26];
        int maxfreq=0;
        int n = s.length;
        while(j<n){
            freq[s.charAt(j)-'A']++;

        }
    }
}