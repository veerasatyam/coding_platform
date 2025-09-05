class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if (target == color) return image;
        dfs(image, sr, sc, color, target);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int target) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if (image[sr][sc] != target) return;
        image[sr][sc] = color;
        dfs(image, sr + 1, sc, color, target);
        dfs(image, sr - 1, sc, color, target);
        dfs(image, sr, sc + 1, color, target);
        dfs(image, sr, sc - 1, color, target);
    }
}
