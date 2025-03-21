class Solution {
    public int balancedStringSplit(String s) {
        int count=0,rc=0,lc=0;
        for(char a : s.toCharArray())
        {
            if(a=='L')lc++;
            if(a=='R')rc++;
            if(lc==rc)
            {
                lc=rc=0;
                count++;
            }
        }
        return count;
    }
}