import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class CustomStack {
    ArrayList<Integer> stack;
    int maxSize;
    int size;

    public CustomStack(int maxSize) {
        this.stack = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
        this.size = 0;
    }

    public void push(int x) {
        if (this.maxSize > this.stack.size()) {
            this.stack.add(x);
            this.size += 1;
        }
    }

    public int pop() {
        if (this.size == 0) {
            return -1;
        }
        int res = this.stack.get(this.size - 1);
        stack.remove(this.size - 1);
        this.size -= 1;
        return res;
    }

    public void increment(int k, int val) {
        if (k >= this.size) {
            k = this.size;
            CustomStack s = new CustomStack(k);
            for (int i = 0; i < k; i++) {
                s.push(this.pop() + val);
            }
            for (int i = 0; i < k; i++) {
                this.push(s.pop());
            }
        }
        else {
            CustomStack s = new CustomStack(this.size);
            for (int i = 0; i < this.size - k; i++) {
                s.push(this.pop());
            }
            for (int i = 0; i < k; i++) {
                s.push(this.pop() + val);
            }
            int l = s.size;
            for (int i = 0; i < l; i ++) {
                this.push(s.pop());
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}