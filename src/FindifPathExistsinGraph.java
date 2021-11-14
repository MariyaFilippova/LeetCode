public class FindifPathExistsinGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int [] edge: edges) {
            int first = find(parents, edge[0]);
            int second = find(parents, edge[1]);
            parents[first] = second;
        }
        return find(parents, start) == find(parents, end);
    }

    int find(int[] parents, int i) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents, parents[i]);
    }

    public static void main(String[] args) {
        new FindifPathExistsinGraph().validPath(3, new int[][] {{0,1},{1,2},{2,0}}, 0, 2);
    }
}
