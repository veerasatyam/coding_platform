// for stack solution check out the stack directory 



// brute force

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int[] knowMe = new int[n];
        int[] Iknow = new int[n];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++){
                if (mat[i][j] == 1) {
                    knowMe[j]++;
                    Iknow[i]++;
                }
            }
        }
        for (int i = 0;i < n;i++){
            if (knowMe[i] == n && Iknow[i] == 1) return i;
            
        }
        return -1;
    }
}


// using two pointers 
class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (mat[j][i] == 1)j--;
            else i++;
        }
        int c = i;
        for (i = 0;i < n;i++) {
            if (i == c) continue;
            if (mat[c][i] != 0 || mat[i][c] == 0)
                return -1;
        }
        return c;
    }
}