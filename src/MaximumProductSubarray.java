import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaximumProductSubarray {
    public int maxProduct(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int max_ending_here = 1;
        int min_ending_here = 1;

        int max_so_far = 1;
        int flag = 0;
        int zero_flag = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                max_ending_here = max_ending_here * arr[i];
                min_ending_here = min(min_ending_here * arr[i], 1);
                flag = 1;
            }

            else if (arr[i] == 0) {
                zero_flag = 1;
                max_ending_here = 1;
                min_ending_here = 1;
            }

            else {
                int temp = max_ending_here;
                max_ending_here = max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        if (zero_flag == 1 && flag == 0 && max_so_far == 1) {
            return 0;
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new MaximumProductSubarray().maxProduct(nums);
    }

}
