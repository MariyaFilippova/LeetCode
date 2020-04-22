import java.util.Scanner;
import java.util.Stack;

class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        int n = pushed.length;
        int m = popped.length;
        Stack<Integer> stack = new Stack<>();
        while( i < n && j < m) {
            if (popped[j] != pushed[i]) {
                stack.push(pushed[i]);
                i++;
            }
            else {
                j++;
                i++;
                while(!stack.empty() && popped[j] == stack.peek()) {
                    j++;
                    stack.pop();
                }
            }
        }
        if ( j == m && stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] pushed = new int[n];
        int[] poped = new int[m];
        for (int i = 0; i< n; i++) {
            pushed[i] = scanner.nextInt();
        }
        for(int i = 0; i< m; i++) {
            poped[i] = scanner.nextInt();
        }
        new ValidateStackSequences().validateStackSequences(pushed, poped);
    }
}
