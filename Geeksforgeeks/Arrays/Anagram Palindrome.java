class Solution {
    public boolean canFormPalindrome(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0)oddCount++;           
            if (oddCount > 1)return false;
        }
        return true;
    }
}
