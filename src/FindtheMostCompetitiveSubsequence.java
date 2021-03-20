import java.util.Stack;

public class FindtheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> res = new Stack<>();
        int i = 0;

        while (i < nums.length) {
            int num = nums[i];
            int leftElements = nums.length - i;
            while (!stack.empty() && stack.peek() > num && stack.size() + leftElements > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(num);
            }
            i++;
        }
        int [] out = new int[k];
        for (i = k - 1; i >= 0; i--) {
            out[i] = stack.pop();
        }
        return out;
    }
}
