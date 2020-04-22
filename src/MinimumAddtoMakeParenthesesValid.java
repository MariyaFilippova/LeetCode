import java.util.Scanner;
import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int i = 0;
        int counter = 0;
        Stack<Character> stack = new Stack<Character>();
        while ( i < S.length()) {
            if (S.charAt(i) == ')') {
                stack.push(S.charAt(i));
            }
            else if(!stack.empty()){
                stack.pop();
            }
            else {
                counter++;
            }

        }
        return stack.size() + counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        new MinimumAddtoMakeParenthesesValid().minAddToMakeValid(s);
    }
}
