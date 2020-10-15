import java.util.Arrays;

public class RemoveMaxNumberofEdges {
    int counter = 0;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int [] e: edges) {
            if (e[0] == 3) {
                int v = findParent(parents, e[1] - 1);
                int u = findParent(parents, e[2] - 1);
                if (u != v) {
                    parents[u] = v;
                    counter++;
                }
            }
        }
        int[] parentsAlice = parents.clone();
        int[] parentsBob = parents.clone();
        for (int [] e: edges) {
            if (e[0] == 1) {
                int v = findParent(parentsAlice, e[1] - 1);
                int u = findParent(parentsAlice, e[2] - 1);
                if (u != v) {
                    parentsAlice[u] = v;
                    counter++;
                }
            }
        }
        for (int [] e: edges) {
            if (e[0] == 2) {
                int v = findParent(parentsBob, e[1] - 1);
                int u = findParent(parentsBob, e[2] - 1);
                if (u != v) {
                    parentsBob[u] = v;
                    counter++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            parentsAlice[i] = findParent(parentsAlice, i);
            parentsBob[i] = findParent(parentsBob, i);
        }
        return  !Arrays.stream(parentsAlice).allMatch(a -> a == parentsAlice[0]) || !Arrays.stream(parentsBob).allMatch(a -> a == parentsBob[0]) ? -1 : edges.length - counter;
    }

    int findParent(int [] parents, int v) {
        if (parents[v] == v) {
            return v;
        }
        return parents[v] = findParent(parents, parents[v]);
    }
}
