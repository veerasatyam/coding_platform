// class Solution {
//     public int equalPairs(int[][] grid) {
//         int n = grid.length;
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 boolean match = true;
//                 for (int k = 0; k < n; k++) {
//                     if (grid[i][k] != grid[k][j]) {
//                         match = false;
//                         break;
//                     }
//                 }
//                 if (match) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }

//optimsied version

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(",");
            }
            String rowStr = sb.toString();
            rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
        }
        
        int count = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append(",");
            }
            String colStr = sb.toString();
            count += rowMap.getOrDefault(colStr, 0);
        }
        
        return count;
    }
}
