class Solution {
    public int mirrorFrequency(String s) {
        int[] freq = new int[26];
        int[] numsFreq = new int[10];
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) numsFreq[x - '0']++;
            else freq[x - 'a']++;
            
        }
        int absSum = 0;
        for (int i = 0; i < 26; i++) {
            int mirror = 25 - i;
            if (i <= mirror) {
                absSum += Math.abs(freq[i] - freq[mirror]);
            }
        }
        for (int i = 0; i < 10; i++) {
            int mirror = 9 - i;
            if (i <= mirror) {
                absSum += Math.abs(numsFreq[i] - numsFreq[mirror]);
            }
        }
        return absSum;
    }
}