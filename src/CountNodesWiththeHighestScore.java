import java.util.ArrayList;

public class CountNodesWiththeHighestScore {
    long max = Integer.MIN_VALUE;
    int counter = 0;

    public int countHighestScoreNodes(int[] parents) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        int n = parents.length;
        long [] sizes = new long[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int parent = parents[i];
            if (parent != -1) {
                tree.get(parent).add(i);
            }
        }
        dfs(sizes, 0, tree);
        return counter;
    }

    public long dfs(long[] sizes, int vertex, ArrayList<ArrayList<Integer>> tree) {
        int size = 0;
        long prod = 1L;
        for (int child: tree.get(vertex)) {
            long val = dfs(sizes, child, tree);
            size += val;
            prod *= val;
        }
        long ostatok = tree.size() - size - 1;
        if (ostatok > 0) {
            prod *= ostatok;
        }
        if (max < prod) {
            max = prod;
            counter = 1;
        }
        else if (max == prod) {
            counter++;
        }
        return size + 1;
    }
}
