class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int clr = image[sr][sc];
        if (clr != newColor) dfs(image, sr, sc, clr, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int clr, int newColor) {
        if (image[r][c] == clr) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, clr, newColor);
            if (c >= 1) dfs(image, r, c-1, clr, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, clr, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, clr, newColor);
        }
    }
}
