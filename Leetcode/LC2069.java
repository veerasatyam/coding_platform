class Robot {
    final int[][] dir = {
        {1,0},  // East 
        {0,1},  // North
        {-1,0}, // West
        {0,-1}  // South
    };

    int x, y;
    int xb, yb;
    int d = 0;

    public Robot(int width, int height) {
        x = y = 0;
        xb = width;
        yb = height;
        d = 0;
    }
    public void step(int num) {
        int perimeter = 2 * (xb + yb) - 4;
        int moves = num % perimeter;
        if (moves == 0 && num > 0) {
            moves = perimeter;
        }
        while (moves-- > 0) {
            int a = dir[d][0];
            int b = dir[d][1];
            int nx = x + a;
            int ny = y + b;
            while (nx >= xb || nx < 0 || ny >= yb || ny < 0) {
                d = (d + 1) % 4;
                a = dir[d][0];
                b = dir[d][1];
                nx = x + a;
                ny = y + b;
            }
            x = nx;
            y = ny;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (d == 0) return "East";
        else if (d == 1) return "North";
        else if (d == 2) return "West";
        else return "South";
    }
}



// better version 
class Robot {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    String[] d = {"East", "North", "West", "South"};
    int x = 0, y = 0, dir = 0;
    int max_w, max_h, perimeter;

    public Robot(int width, int height) {
        max_w = width;
        max_h = height;
        perimeter = 2 * (width + height) - 4;
    }
    public void step(int num) {
        num %= perimeter;
        if(num == 0){
            if(x == 0 && y == 0){
                dir = 3;
            }
            return;
        }
        while(num > 0){
            int nx = x + dx[dir], ny = y + dy[dir];
            if(nx < 0 || nx >= max_w || ny < 0 || ny >= max_h){
                dir = (dir + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
            num--;
        }
    }

    public int[] getPos() {
        return new int[] {x, y};
    }    
    public String getDir() {
        return d[dir];
    }
}