import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int elmn = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (counter > nums.length/2) {
                return elmn;
            }
            if (elmn == nums[i]) {
                counter++;
            }
            else {
                counter = 1;
            }
            elmn = nums[i];
        }
        return elmn;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new MajorityElement().majorityElement(nums);
    }
}
