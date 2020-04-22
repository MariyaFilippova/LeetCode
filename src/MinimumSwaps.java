import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumSwaps {

    static boolean isOk(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return false;
            }
        }
        return true;
    }
    static int maxSwaps(int[] nums) {
        int n = nums.length;
        int numberOfSwaps = 0;
        int i = 0;
        while (!isOk(nums)) {
            if (i == n - 1) {
                i = 0;
            }
            if ( i < nums[i] - 1) {
                numberOfSwaps++;
                int j = i + 1;
                while (j + 1 < n && nums[j] < nums[j + 1]) {
                    j++;
                }
                if (j == n - 1) {
                    j = i;
                }
                int s = nums[i];
                nums[i] = nums[j + 1];
                nums[j + 1] = s;
            }
            i++;
        }
        return numberOfSwaps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(new MinimumSwaps().maxSwaps(nums));
    }
}
