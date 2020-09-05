import java.lang.reflect.Array;
import java.util.Arrays;

public class PartitionArrayforMaximumSum {
    public static int maxSumAfterPartitioning(int[] A, int K) {
        if (A.length == 0) {
            return 0;
        }
        int[] d = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= K; j++) {
                if (i >= j) {
                    int l = d[i - j] + getMax(A, i - 1, j) * j;
                    d[i] = Math.max(l, d[i]);
                }
            }
        }
        return d[A.length];
    }

    static int getMax(int [] A, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < j; k++ ) {
            if (max < A[i - k]) {
                max = A[i - k];
            }
        }
        return max;
    }
}
