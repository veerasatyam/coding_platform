class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dr = {
            {0,1}, // north
            {1,0}, // east
            {0,-1}, // south
            {-1,0} // west
        };
        Set<String> set = new HashSet<>();
        for(int[] obs : obstacles){
            int a = obs[0];
            int b = obs[1];
            set.add(a + "," + b);
        }
        int d = 0;
        int x = 0, y = 0;
        int max = 0;
        for(int i = 0;i<commands.length;i++){
            int val= commands[i];
            if(val == -1){
                d = (d + 1) % 4;
            }else if(val == -2){
                d = (d + 3) % 4;
            }else{
                int a = dr[d][0];
                int b = dr[d][1];
                for(int j = 0;j<val;j++){
                    int nx = x + a;
                    int ny = y + b;
                    String str = nx + "," + ny;
                    if(set.contains(str)) break;
                    max = Math.max(max,nx*nx + ny*ny);
                    x = nx;
                    y = ny;
                }
            }
        }
        return max;
    }
}