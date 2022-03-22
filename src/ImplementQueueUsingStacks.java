import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public ImplementQueueUsingStacks() {

    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        if (!second.empty()) {
            return second.pop();
        }
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        return second.pop();
    }

    public int peek() {
        if (!second.empty()) {
            return second.peek();
        }
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        return second.peek();
    }

    public boolean empty() {
        return first.empty() && second.empty();
    }
}
