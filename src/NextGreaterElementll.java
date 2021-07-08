import java.util.Stack;

public class NextGreaterElementll {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i % nums.length);
                res[i % nums.length] = -1;
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                    stack.pop();
                }
                res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
                stack.push(i % nums.length);
            }
        }
        return res;
    }
}
