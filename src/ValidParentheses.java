import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if (stack.empty()) {
                    return false;
                }
                int p = stack.pop();
                if (c == ')' && p == '(' || c == '}' && p == '{' || c == ']' && p == '[') {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
