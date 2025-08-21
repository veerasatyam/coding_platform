class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int[] freq = new int[26];
        int maxfreq = 0;
        int n = s.length();  
        int ans = 1;             
        while (j < n) {
            freq[s.charAt(j) - 'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(j) - 'A']);
            while ((j - i + 1) - maxfreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
