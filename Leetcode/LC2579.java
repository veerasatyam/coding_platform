class Solution {
    public long coloredCells(int n) {
        return 1+(long)2*n*(n-1);
    }
}


// class Solution {
//     public long coloredCells(int n) {
//         if(n==1) return 1;
//         long i=1,total=1;
//         while(i<n)
//         {
//         total = total + 4*i;
//         i++;
//         }
//         return total;
//     }
// }