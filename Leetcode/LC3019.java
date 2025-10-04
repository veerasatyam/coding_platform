class Solution {
    public int countKeyChanges(String s) {
        String str = s.toLowerCase();
        char x = str.charAt(0);
        int count=0;
        for(int i=1;i<s.length();i++){
            if(str.charAt(i)!=x) count++;
            x = str.charAt(i);
        }
        return count;
    }
}