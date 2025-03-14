package Two_pointers;
public class Solution {
    public int solve(int[] A, int[] B, int[] C) {
        int p1 = 0, p2 = 0, p3 = 0;
        int abs = Integer.MAX_VALUE;
        while (p1 < A.length && p2 < B.length && p3 < C.length) {
            int x = Math.max(A[p1], Math.max(B[p2], C[p3]));
            int y = Math.min(A[p1], Math.min(B[p2], C[p3]));
            int diff = x - y;
            abs = Math.min(diff, abs);
            if (A[p1] == y) p1++;
            else if (B[p2] == y) p2++;
            else p3++;
        }
        return abs;
    }
}
