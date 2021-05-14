import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(string.length());
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            }
            string.append(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            string.deleteCharAt(index);
        }
        return string.toString();
    }
}
