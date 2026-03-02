class Solution {
    public int minSwaps(int[][] grid) {
        int n =  grid.length;
        int[] rightMost = new int[n];
        for(int i = 0;i<n;i++) rightMost[i] = FindRM(grid[i]);
        int count = 0;
        for (int i=0;i<n;i++){
            int j = i;
            while (j < n && rightMost[j]>i)j++;
            if (j == n) return -1;
            while (j > i) {
                swap(rightMost,j-1);
                count++;
                j--;
            }
        }
        return count;
    }
    private int FindRM(int[] a){
        int n = a.length;
        for(int i = n-1;i>=0;i--){
            if(a[i]==1) return i;
        }
        return 0;
    }
    private void swap(int[] a,int index){
        int temp = a[index];
        a[index] = a[index+1];
        a[index+1] = temp;
    }
}