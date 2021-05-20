import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> max;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Stack<>();
        max = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (max.empty()) {
            max.push(x);
            return;
        }
        max.push(Math.max(x, max.peek()));
    }

    public int pop() {
        max.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        Stack<Integer> buffer = new Stack<>();
        int maximum = peekMax();
        while (stack.peek() != maximum) {
            buffer.push(stack.pop());
            max.pop();
        }
        stack.pop();
        max.pop();
        while (!buffer.isEmpty()) {
            int x = buffer.pop();
            stack.push(x);
            max.push(max.isEmpty() ? x : Math.max(max.peek(), x));
        }
        return maximum;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

