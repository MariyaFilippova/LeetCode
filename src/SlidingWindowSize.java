import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowSize {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> max = new ArrayList<>();
        int in_max = -2147483648;
        Stack<Integer> in = new Stack<Integer>();
        Stack<Integer> out = new Stack<Integer>();
        Stack<Integer> out_max = new Stack<Integer>();
        for (int i = 0; i < k; i++) {
            in.push(nums[i]);
            in_max = Math.max(in_max, nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (out.empty()) {
                int m = -2147483648;
                while (!in.empty()) {
                    int a = in.pop();
                    out.push(a);
                    m = Math.max(a, m);
                    out_max.push(m);
                }
                in_max = -2147483648;
            }
            if (in.empty()) {
                max.add(out_max.peek());
            }
            else {
                max.add(Math.max(in_max, out_max.peek()));
            }
            in.push(nums[i]);
            in_max = Math.max(in_max, nums[i]);
            out.pop();
            out_max.pop();
        }
        if (out_max.empty()) {
            max.add(in_max);
        }
        else {
            max.add(Math.max(in_max, (int) out_max.peek()));
        }
        int[] res = new int[max.size()];
        for (int i = 0; i<max.size(); i++) {
            res[i] = max.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new SlidingWindowSize().maxSlidingWindow(nums, scanner.nextInt());
    }
}
