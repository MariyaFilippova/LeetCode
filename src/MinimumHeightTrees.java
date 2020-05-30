import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        if (n == 1) {
            list.add(0);
            return list;
        }
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (lists[i].size() == 1) {
                leaves.add(i);
            }
        }
        int counter = n;
        while (counter > 2) {
            counter -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf: leaves) {
                for (int e : lists[leaf]) {
                    lists[e].remove(Integer.valueOf(leaf));
                    if (lists[e].size() == 1) {
                        newLeaves.add(e);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }


    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};

        new MinimumHeightTrees().findMinHeightTrees(n, edges);
    }
}

