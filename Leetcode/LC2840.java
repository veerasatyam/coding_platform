class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] s1_Even_freq1 = new int[26];
        int[] s2_Even_freq1 = new int[26];
        int[] s1_Odd_freq2 = new int[26];
        int[] s2_Odd_freq2 = new int[26];
        int n = s1.length();
        for(int i = 0;i<n;i++){
            if(s1.charAt(i) == s2.charAt(i)) continue;
            if((i & 1) == 0){
                s1_Even_freq1[s1.charAt(i) - 'a']++;
                s2_Even_freq1[s2.charAt(i) - 'a']++;
            }else{
                s1_Odd_freq2[s1.charAt(i) - 'a']++;
                s2_Odd_freq2[s2.charAt(i) - 'a']++;
            }
        }
        return Arrays.equals(s1_Even_freq1,s2_Even_freq1) && Arrays.equals(s1_Odd_freq2,s2_Odd_freq2);
    }
}


// optimal solution 

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            if ((i & 1) == 0) {
                even[c1]++;
                even[c2]--;
            } else {
                odd[c1]++;
                odd[c2]--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) return false;
        }
        return true;
    }
}