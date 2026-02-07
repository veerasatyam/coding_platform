class Solution {
    public boolean checkString(String s) {
        int bcount = 0;
        for(char x : s.toCharArray()){
            if(x=='b') bcount++;
            else if(x=='a' && bcount!=0) return false;
        }
        return true;
    }
}