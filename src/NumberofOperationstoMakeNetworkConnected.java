import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberofOperationstoMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if (m < n - 1) {
            return -1;
        }
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] connection : connections) {
            int v = find(parents, connection[0]);
            int u = find(parents, connection[1]);
            if (u != v) {
                parents[u] = v;
            }
        }
        for (int i = 0; i < n; i++) {
            parents[i] = find(parents, i);
        }
        Set set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(parents[i]);
        }
        return set.size() - 1;
    }

    int find(int[] parents, int v) {
        if (parents[v] == v) {
            return v;
        }
        return parents[v] = find(parents, parents[v]);
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] connections = new int[n - 1][2];
        connections[0][0] = 0;
        connections[0][1] = 1;
        connections[1][0] = 0;
        connections[1][1] = 2;
        connections[2][0] = 3;
        connections[2][1] = 4;
        connections[3][0] = 2;
        connections[3][1] = 3;
        new NumberofOperationstoMakeNetworkConnected().makeConnected(n, connections);
    }
}
