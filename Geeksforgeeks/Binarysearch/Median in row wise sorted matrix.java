// brute force
class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[n * m];
        int k = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[k++] = mat[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[(n * m) / 2];
    }
}

// using priority Queue
class Solution {
    class Node {
        int val, row, col;
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int median(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int total = r * c;
        int mediantotal = (total + 1) / 2;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0;i < r;i++)pq.add(new Node(mat[i][0], i, 0));
        int count = 0;
        int median = -1;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            count++;
            if (count == mediantotal) {
                median = node.val;
                break;
            }
            if (node.col + 1 < c) {
                pq.add(new Node(mat[node.row][node.col + 1], node.row, node.col + 1));
            }
        }
        return median;
    }
}

// binary search 
class Solution {
    public int median(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int total = n * m;
        int k = (total + 1) / 2;
        int l = findMin(mat);
        int h = findMax(mat,m);

        while (l < h) {
            int mid = (l + h) / 2;
            int cnt = count(mat, mid);
            if (cnt < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    private int findMax(int[][] mat,int m) {
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            max = Math.max(max, mat[i][m - 1]);
        }
        return max;
    }

    private int findMin(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            min = Math.min(min, mat[i][0]);
        }
        return min;
    }

    private int count(int[][] mat, int target) {
        int c = 0;
        for (int i = 0; i < mat.length; i++) {
            c += countSmallerEqual(mat[i], target);
        }
        return c;
    }

    private int countSmallerEqual(int[] row, int target) {
        int l = 0, h = row.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }
}