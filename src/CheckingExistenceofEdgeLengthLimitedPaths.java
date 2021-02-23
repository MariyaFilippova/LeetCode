import java.util.Arrays;
import java.util.Comparator;

public class CheckingExistenceofEdgeLengthLimitedPaths {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        if (queries.length == 0) {
            return new boolean[]{};
        }
        boolean[] result = new boolean[queries.length];
        int[][] newQueries = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = queries[i][2];
            newQueries[i][3] = i;
        }
        Arrays.sort(edgeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        Arrays.sort(newQueries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0, j = 0; i < queries.length; i++) {
            while (j < edgeList.length && edgeList[j][2] < newQueries[i][2]) {
                int source = edgeList[j][0];
                int dst = edgeList[j][1];
                int parentSource = findParents(source, parents);
                int parentDst = findParents(dst, parents);
                parents[parentDst] = parentSource;
                j++;
            }

            result[newQueries[i][3]] = findParents(newQueries[i][0], parents) == findParents(newQueries[i][1], parents);
        }
        return result;
    }

    int findParents(int v, int[] parents) {
        if (v == parents[v]) {
            return v;
        }
        return parents[v] = findParents(parents[v], parents);
    }
}

