class Solution {
    public int maxDistance(String moves) {
        int x = 0;
        int y = 0;
        int underscore = 0;
        for(char m : moves.toCharArray()){
            if(m == 'L') x--;
            else if(m == 'R') x++;
            else if(m == 'U') y++;
            else if(m == 'D') y--;
            else underscore++;
        }
        return Math.abs(x) + Math.abs(y) + underscore;
    }
}