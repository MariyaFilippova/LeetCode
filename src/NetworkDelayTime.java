import java.util.Scanner;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Graph g = new Graph(N);
        int[] distances = new int[N];
        int k = times.length;
        for (int i = 0; i < k; i++) {
            g.matrix[times[i][0]-1][times[i][1]-1] = times[i][2];
        }
        distances = g.dijkstraDistance(K - 1, N);
        int max = -1;
        for (int i = 0; i < N; i++) {
            if (distances[i] == 2147483647) {
                return -1;
            }
        }
        for (int i = 0; i < N; i++) {
            if (distances[i] > max) {
                max = distances[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] times = new int[m][3];
        for (int i = 0; i<m; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
            times[i][2] = scanner.nextInt();
        }
        new NetworkDelayTime().networkDelayTime(times, n, k);
    }

}

