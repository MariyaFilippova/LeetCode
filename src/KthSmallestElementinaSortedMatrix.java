import java.util.Scanner;

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int counter = 0;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = (high - low) / 2 + low;
            counter = countLess(matrix, mid, n);
            if (counter < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    public int countLess(int[][] matrix, int mid, int n) {
        int counter = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            while (j >= 0 && matrix[i][j] > mid) {
                j--;
            }
            counter += j + 1;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

    }
}
