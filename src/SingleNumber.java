import java.util.Scanner;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single=0;
        for(int i:nums)
            single^=i;
        return single;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new SingleNumber().singleNumber(nums);
    }
}
