// class Solution {
//     public int[] colorTheArray(int n, int[][] queries) {
//         int[] colors = new int[n];
//         int[] ans = new int[queries.length];
//         for (int i = 0; i < queries.length; i++) {
//             int index = queries[i][0];
//             int newColor = queries[i][1];
//             colors[index] = newColor;
//             ans[i] = countPairs(colors);
//         }
//         return ans;
//     }
//     private int countPairs(int[] colors) {
//         int count = 0;
//         for (int i = 0; i < colors.length - 1; i++) {
//             if (colors[i] != 0 && colors[i] == colors[i + 1]) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

//optimised version 
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] ans = new int[queries.length];
        int pairs = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int newColor = queries[i][1];
            if (colors[index] != 0) {
                if (index > 0 && colors[index] == colors[index - 1]) pairs--;
                if (index < n - 1 && colors[index] == colors[index + 1]) pairs--;
            }
            colors[index] = newColor;
            if (colors[index] != 0) {
                if (index > 0 && colors[index] == colors[index - 1]) pairs++;
                if (index < n - 1 && colors[index] == colors[index + 1]) pairs++;
            }
            ans[i] = pairs;
        }
        return ans;
    }
}
