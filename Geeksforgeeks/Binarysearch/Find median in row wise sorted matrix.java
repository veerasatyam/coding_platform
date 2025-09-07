// class Solution {
//     class Node {
//         int val, row, col;
//         Node(int val, int row, int col) {
//             this.val = val;
//             this.row = row;
//             this.col = col;
//         }
//     }
//     public int median(int[][] mat) {
//         int r = mat.length;
//         int c = mat[0].length;
//         int total = r * c;
//         int mediantotal = (total + 1) / 2;
//         PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
//         for (int i = 0; i < r; i++) {
//             pq.add(new Node(mat[i][0], i, 0));
//         }

//         int count = 0;
//         int median = -1;

//         while (!pq.isEmpty()) {
//             Node node = pq.poll();
//             count++;

//             if (count == mediantotal) {
//                 median = node.val;
//                 break;
//             }
//             if (node.col + 1 < c) {
//                 pq.add(new Node(mat[node.row][node.col + 1], node.row, node.col + 1));
//             }
//         }

//         return median;
//     }
// }



//using binary search
class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int desired = (m * n + 1) / 2;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, mat[i][0]);
            max = Math.max(max, mat[i][m - 1]);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            int places = 0;

            for (int i = 0; i < n; i++) {
                places += countLessEqual(mat[i], mid);
            }

            if (places < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
    private int countLessEqual(int[] row, int x) {
        int l = 0, r = row.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (row[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; 
    }
}
