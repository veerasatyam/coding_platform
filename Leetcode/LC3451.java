class Solution {
    public int maxFreqSum(String s) {
        int[] frequneces = new int[26];
        int max_vowel=0;
        int max_consonent=0;
        for(char x : s.toCharArray()){
            frequneces[x-'a']++;
            if(x=='a' || x=='e' || x=='i' || x=='o'|| x=='u'){
                max_vowel = Math.max(max_vowel,frequneces[x-'a']);
            }else{
                max_consonent = Math.max(max_consonent,frequneces[x-'a']);
            }
        }
        return max_consonent+max_vowel;
    }
}