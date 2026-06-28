import java.util.Stack;

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) stack.push(i);
        while (stack.size() > 1){
            int a = stack.pop();
            int b = stack.pop();
            if(mat[a][b] == 1){
                stack.push(b);
            }else{
                stack.push(a);
            }
        }
        int x = stack.pop();
        for(int i = 0; i< n; i++){
            if (i == x) continue;
            if (mat[i][x] == 0 || mat[x][i] == 1) {
                return -1;
            }
        }
        return x;
    }
}