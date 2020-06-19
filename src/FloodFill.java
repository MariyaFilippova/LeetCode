public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        if (n == 0) {
            return image;
        }
        int m = image[0].length;
        if (image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int newColor,  int color) {
        if (image[i][j] == color) {
            image[i][j] = newColor;
            if (i != 0) {
                dfs(image, i - 1, j, newColor, color);
            }
            if (j != 0) {
                dfs(image, i , j - 1, newColor, color);
            }
            if (i != image.length - 1) {
                dfs(image, i + 1, j, newColor, color);
            }if (j != image[0].length - 1) {
                dfs(image, i , j + 1, newColor, color);
            }
        }
    }
}
