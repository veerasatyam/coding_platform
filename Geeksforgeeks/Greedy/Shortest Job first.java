class Solution {
    static int solve(int bt[]) {
        int total = 0;
        Arrays.sort(bt);
        int time = 0;
        for(int i = 0; i < bt.length; i++){
            total += time;
            time += bt[i];
        }
        return total / bt.length;
    }
}
