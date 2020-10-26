import java.lang.reflect.Array;
import java.util.*;

class FindCriticalandPseudoCriticalEdges {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    int[] parents;
    int bestWeight = 0;

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        if (n == 0 || edges.length == 0) {
            return new ArrayList<>();
        }
        parents = new int[n];
        setParents(n);
        queue.addAll(Arrays.asList(edges));

        Set<Integer> mst = new HashSet<>();

        bestWeight = getSTWeight();

        for (int i = 0; i < edges.length; i++) {
            if (isInMST(i, edges, n)) {
                mst.add(i);
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            setParents(n);
            fillQueue(i, edges);
            int w = getSTWeight();
            if (w > bestWeight || !connected(parents, n)) {
                critical.add(i);
            } else {
                if (mst.contains(i)) {
                    pseudoCritical.add(i);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pseudoCritical);
        return res;
    }

    boolean isInMST(int i, int[][] edges, int n) {
        int w = 0;
        setParents(n);
        parents[edges[i][0]] = edges[i][1];
        w += edges[i][2];
        fillQueue(i, edges);
        w += getSTWeight();
        return bestWeight == w;
    }

    void fillQueue(int i, int[][] edges) {
        for (int j = 0; j < edges.length; j++) {
            if (i != j) {
                queue.add(edges[j]);
            }
        }
    }

    int getSTWeight() {
        int bestWeight = 0;
        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            int v = findParent(e[0], parents);
            int u = findParent(e[1], parents);
            if (u != v) {
                bestWeight += e[2];
                parents[u] = v;
            }
        }
        return bestWeight;
    }

    boolean connected(int[] parents, int n) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < n; j++) {
            int v = findParent(j, parents);
            set.add(v);
        }
        return set.size() == 1;
    }

    void setParents(int n) {
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    int findParent(int v, int[] parents) {
        if (v == parents[v]) {
            return v;
        }
        return parents[v] = findParent(parents[v], parents);
    }

    public static void main(String[] args) {
        new FindCriticalandPseudoCriticalEdges().findCriticalAndPseudoCriticalEdges(4, new int[][]{{0,1,1},{0,3,1},{0,2,1},{1,2,1},{1,3,1},{2,3,1}});
    }
}
