import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int max = 0;
        int maximum = 0;
        int i = 0;
        int j = 0;
        while( j < nums.length) {
            max = 0;
            i = j;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                max++;
            }
            if (max > maximum) {
                maximum = max;
            }
            j++;
        }
        return maximum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new ArrayNesting().arrayNesting(nums);
    }
}
