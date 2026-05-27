class Solution {
    public int numberOfSpecialChars(String word) {
       int[] small = new int[26];
        int[] capital = new int[26];
        Arrays.fill(small,-1);
        Arrays.fill(capital,-1);
        int count = 0;
        for(int i = 0;i< word.length();i++){
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                small[ch-'a'] = i;
            }else if(ch >= 'A' && ch <= 'Z'){
                if(capital[ch - 'A'] == -1){
                    capital[ch - 'A'] = i;
                }
            }
        }
        for(int i = 0;i<26;i++){
            if(small[i] != -1 && capital[i] != -1 &&capital[i] > small[i]) count++;
        }
        return count;
    }
}