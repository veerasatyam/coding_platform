class Solution {
    public boolean judgeCircle(String moves) {
        int u=0,d=0,l=0,r=0;
        for(char a : moves.toCharArray())
        {
          if(a=='L') l++;
          else if(a=='R') r++;
          else if(a=='U') u++;
          else d++;
        }
        return (u==d && r==l);
    }
}