import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        Arrays.sort(trips, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                if (trips[i][1] < trips[j][2]) {
                    sum = sum + trips[j][0];
                    if (sum > capacity) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] trips = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                trips[i][j] = scanner.nextInt();
            }
        }
        int capacity = scanner.nextInt();
        new CarPooling().carPooling(trips, capacity);
    }
}
