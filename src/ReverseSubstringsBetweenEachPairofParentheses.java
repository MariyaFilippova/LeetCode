import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
    public String reverseParentheses(String s) {
        Stack<Integer> opened = new Stack<>();
        int i = 0;
        int[] pair = new int[s.length()];
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                opened.push(i);
            }
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0, d = 1; k < s.length(); k += d) {
            if (s.charAt(k) == '(' || s.charAt(k) == ')') {
                k = pair[k];
                d = -d;
            }
            else {
                sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }
}
