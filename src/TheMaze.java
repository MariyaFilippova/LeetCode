public class TheMaze {
    int[][] dirs = new int[][]{{0, 1, 1}, {1, 0, 2}, {-1, 0, 3}, {0, -1, 4}};
    boolean[][] visited;
    int[] destination;
    int[][] maze;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        this.destination = destination;
        this.maze = maze;
        return dfs(start);
    }

    boolean dfs(int[] start) {
        if (start[0] == -1 || start[1] == -1 || start[0] == maze.length || start[1] == maze[0].length || visited[start[0]][start[1]]) {
            return false;
        }
        visited[start[0]][start[1]] = true;

        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
        while (r < maze[0].length && maze[start[0]][r] == 0) // right
            r++;
        if (dfs(new int[] {start[0], r - 1}))
            return true;
        while (l >= 0 && maze[start[0]][l] == 0) //left
            l--;
        if (dfs(new int[] {start[0], l + 1}))
            return true;
        while (u >= 0 && maze[u][start[1]] == 0) //up
            u--;
        if (dfs(new int[] {u + 1, start[1]}))
            return true;
        while (d < maze.length && maze[d][start[1]] == 0) //down
            d++;
        if (dfs(new int[] {d - 1, start[1]}))
            return true;
        return false;
    }
}
