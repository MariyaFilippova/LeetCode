import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    public int partition(int num, int start, int end, int[] nums) {
        int mid = (start + end) / 2;
        if (num == nums[mid] && start >= mid) {
            return mid;
        }
        if (num < nums[mid]) {
            return partition(num, start, mid, nums);
        }
        return partition(num, mid + 1, end, nums);
    }

    public int binarySearch(int num, int start, int end, int[] nums) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (num == nums[mid] ) {
                return mid;
            }
            if (num < nums[mid]) {
                return binarySearch(num, start, mid, nums);
            }
            if (num > nums[mid]) {
                return binarySearch(num, mid + 1, end, nums);
            }
        }
        return -1;
    }


    public int getIndexOfLargerElmnt(int num, int[] nums) {
        int index = partition(num, 0, nums.length - 1, nums);
        int place = binarySearch(num, 0, nums.length - 1, nums);
        if (index == 0 && place == -1) {
            return nums.length;
        }
        if (index == nums.length - 1 && place == -1) {
            return 0;
        }
        return index;
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if ((n + m) % 2 != 0) {
            int L = (n + m) / 2;


        }
        System.out.println(nums1.toString());
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(new MedianOfTwoSortedArrays().partition(num, 0, nums.length - 1, nums));
    }


}
