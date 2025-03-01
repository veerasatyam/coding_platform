class Solution
{
     public int find(int N) {
        return findHelper(N, 1, 0); 
    }

    private int findHelper(int N, int s, int sum) {
        if (sum == N) return s - 1;
        if (sum > N) return -1; 

        return findHelper(N, s + 1, sum + s);
    }
}