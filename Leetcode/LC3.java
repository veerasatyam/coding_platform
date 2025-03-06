class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] alphabet = new int[128];
        int max = 0, left = 0, count = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            alphabet[c]++;

            while (alphabet[c] > 1) {
                alphabet[s.charAt(left)]--;
                left++;
                count--;
            }

            count++;
            max = Math.max(max, count);
        }

        return max;
    }
}
