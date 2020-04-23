import java.util.Scanner;


public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        leftProduct[0] = nums[0];
        leftProduct[1] = nums[0];
        int[] rightProduct = new int[n];
        rightProduct[n-1] = nums[n-1];
        rightProduct[n-2] = nums[n-1];
        for (int i = 2; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }
        for (int i = n - 3; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i+1];
        }
        nums[0] = rightProduct[0];
        nums[n - 1] = leftProduct[n-1];
        for (int i = 1; i<n - 1; i++) {
            nums[i] = leftProduct[i] * rightProduct[i];
        }
        return nums;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new ProductofArrayExceptSelf().productExceptSelf(nums);
    }
}
