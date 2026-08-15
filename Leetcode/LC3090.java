class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int n = s.length();
        int ans = 0;
        int i = 0, j = 0;
        while (j < n){
            int c = s.charAt(j) - 'a';
            freq[c]++;
            while (freq[c] > 2) {
                freq[s.charAt(i) - 'a']--;
                i++;
            }
            ans = Math.max(ans,j - i + 1);
            j++;
        }
        return ans;
    }
}