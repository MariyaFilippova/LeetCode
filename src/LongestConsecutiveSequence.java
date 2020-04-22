import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) {
            map.put(nums[i], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            if (!map.containsValue(value - 1)) {
                int j = 1;
                while (map.containsValue(value+j)) {
                    j++;
                }
                if (j > max) {
                    max = j;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new LongestConsecutiveSequence().longestConsecutive(nums);
    }
}
