import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n =nums.length;
        int[] freq = new int[nums.length];
        for (int i = 0; i < n; i++) {
            if (nums[i] == i) {
                freq[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (freq[i] > 1) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i<n; i++) {
            nums[i] = scanner.nextInt();
        }
        new FindAllDuplicatesinanArray().findDuplicates(nums);
    }
}
