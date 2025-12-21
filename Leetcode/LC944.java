class Solution {
    public int minDeletionSize(String[] str) {
        int count = 0;
        int n = str[0].length();
        int len = str.length;
        for(int i=0;i<n;i++){
            int x = str[0].charAt(i) - 'a';
            for(int j=1;j<len;j++){
                if((str[j].charAt(i)-'a') < str[j-1].charAt(i)-'a'){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}