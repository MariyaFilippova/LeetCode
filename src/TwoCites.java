import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TwoCites {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });
        int n = costs.length;

        int cost = 0;
        for ( int i = 0; i < n/2; i++) {
            cost = cost + costs[i][0];
        }
        for ( int i = n/2 - 1; i >= 0; i--) {
            cost = cost + costs[i][1];
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] costs = new int[n][2];
        for (int i = 0; i < n; i++) {
            costs[i][0] = scanner.nextInt();
            costs[i][1] = scanner.nextInt();
        }
        new TwoCites().twoCitySchedCost(costs);
    }
}
