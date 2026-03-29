class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        for(int i = 0;i<4;i++){
            if(a[i] == b[i]) continue;
            if(i < 2){
                if(a[i] != b[i+2]) return false;
            } 
            else{
                if(a[i] != b[i-2]) return false;
            }
        }
        return true;
    }
}