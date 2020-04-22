import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        int number = 0;
        PriorityQueue<Integer> n = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            n.add(-nums[i]);
        }
        for (int i = 0; i < k; i++) {
            number = n.poll();
        }
        return -number;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        new KthLargestElementInArray().findKthLargest(nums, k);
    }
}
