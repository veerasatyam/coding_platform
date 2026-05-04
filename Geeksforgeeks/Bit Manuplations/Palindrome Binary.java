class Solution {
    public boolean isBinaryPalindrome(int n) {
        StringBuilder str = new StringBuilder();
       while(n>0){
           if((n & 1) == 1) str.append(1);
           else str.append(0);
           n = n >> 1;
       }
       return isPalindrom(str.toString());
    }
    private boolean isPalindrom(String s){
        int i = 0,j=s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            j--;
            i++;
        }
        return true;
    }
}




        // if (x == 0) return true;
        // int n = (int)(Math.log(x) / Math.log(2)) + 1;
        // int l = 0, r = n - 1;
        // while (l < r) {
            
        //     // Compare bits at positions l and r
        //     if (((x >> l) & 1) != ((x >> r) & 1)) {
        //         return false;
        //     }
        //     l++;
        //     r--;
        // }
        // return true;