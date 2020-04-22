import java.util.Scanner;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Graph g = new Graph(n);
        int k = edges.length;
        for (int i = 0; i < k; i++) {
            g.matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            g.matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        int[] counter = new int[n];
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist = g.dijkstraDistance(i, n);
            for (int j = 0; j < n; j++) {
                if (dist[j] > distanceThreshold)
                    counter[j]++;
            }
        }
        int v = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (c <= counter[i]) {
                v = i;
                c = counter[i];
            }
        }
        return v;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        int[][] edges = new int[k][3];
        for (int i = 0; i < k; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }
        System.out.println(new FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance().findTheCity(n, edges, d));
    }
}

class Graph {
    private static final int infinity = 2147483647;
    int[][] matrix;  // матрица смежностей

    Graph(int n) {
        this.matrix = new int[n][n];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = infinity;
            }
        }
    }

    private int getMin(boolean[] isVisited, int[] distances, int n) {
        int min = infinity;
        int v = -1;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                if (min > distances[i]) {
                    min = distances[i];
                    v = i;
                }
            }
        }
        return v;
    }

    int[] dijkstraDistance(int v, int n) {
        int[] distances = new int[n];
        // массив, показывающий, была ли посещена вершина c номером i
        boolean[] isVisited = new boolean[n];
        // изначально все расстояния до выбранной вершины infinity, и все вершины не посещены
        distances[v] = 0;
        for (int i = 0; i < n; i++) {
            if (i != v) {
                distances[i] = infinity;
            }
        }
        for (; ; ) {
            // находим наименее удаленную вершину
            int q = getMin(isVisited, distances, n);
            // если такой нет (все вершины посещены), выходим
            if (q == -1) {
                break;
            }
            isVisited[q] = true;
            // для каждой непосещенной вершины, у которой есть ребро с найденной, улучшаем расстрояние (релаксация)
            for (int j = 0; j < n; j++) {
                if (!isVisited[j] && this.matrix[q][j] < infinity) {
                    distances[j] = Math.min(distances[j], distances[q] + this.matrix[q][j]);
                }
            }
        }
        return distances;
    }
}