class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray())freq[ch - 'a']++;
        int[] freq1 = new int[26];
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0;i < 26;i++) {
            int count = freq[i];
            char x = (char) ('a' + i);
            str1.append(String.valueOf(x).repeat(count / 2));
            str2.append(String.valueOf(x).repeat(count / 2));
            if (count % 2 == 1)freq1[i] = 1;
        } 
        for (int i = 0;i < 26;i++) {
            if (freq1[i] == 1) {
                str1.append((char) ('a' + i));
                break;
            }
        }
        str1.append(str2.reverse());
        return str1.toString();
    }
}