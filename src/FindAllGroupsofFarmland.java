import java.util.ArrayList;

public class FindAllGroupsofFarmland {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}};
    int[][] visited;

    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> result = new ArrayList<>();
        if (land.length == 0 || land[0].length == 0) {
            return new int[][]{};
        }
        visited = new int[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) continue;
                int x = i;
                int y = j;
                while (x < land.length && land[x][j] == 1) {
                    x++;
                }
                while (y < land[0].length && land[i][y] == 1) {
                    y++;
                }
                for (int a = i; a < x; a++) {
                    for (int b = j; b < y; b++) {
                        land[a][b] = 0;
                    }
                }
                result.add(new int[]{i, j, x - 1, y - 1});
            }
        }
        return result.toArray(new int[0][]);
    }
}
