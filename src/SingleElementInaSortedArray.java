import java.util.Scanner;

public class SingleElementInaSortedArray {

    public int search(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (mid < nums.length - 1 && nums[mid] == nums[mid+1] || mid > 0 && nums[mid] == nums[mid-1]) {
            return search(nums, start, mid - 1) == -1 ? search(nums, mid+1, end) : search(nums, start, mid - 1);
        }
        return nums[mid];
    }

    public int singleNonDuplicate(int[] nums) {
        return search(nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i<n; i++) {
            nums[i] = scanner.nextInt();
        }
        new SingleElementInaSortedArray().singleNonDuplicate(nums);
    }
}
