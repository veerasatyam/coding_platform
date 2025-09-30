class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        
        for (int[] row : image) {
            int left = 0, right = n - 1;
            while (left <= right) {
                if (row[left] == row[right]) {
                    row[left] = 1 - row[left];
                    row[right] = row[left];
                }
                left++;
                right--;
            }
        }
        return image;
    }
}
