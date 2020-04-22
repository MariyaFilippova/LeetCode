import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minimums;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minimums = new Stack<>();
    }

    public void push(int x) {
        if (minimums.empty()) {
            minimums.push(x);
        }
        else {
            if (minimums.peek() > x) {
                minimums.push(x);
            }
            else {
                minimums.push(minimums.peek());
            }
        }
        stack.push(x);
    }

    public void pop() {
        minimums.pop();
        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return minimums.peek();
    }
}

