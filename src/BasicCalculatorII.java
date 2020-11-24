import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        char operation = '+';
        int number = 0;
        for (i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (Character.isDigit(s.charAt(i))) {
                    number = number * 10 + s.charAt(i) - '0';
                }
            }
            if (!Character.isWhitespace(s.charAt(i)) && !Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                switch (operation) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop()*number);
                        break;
                    case '/':
                        stack.push(stack.pop()/number);
                }
                operation = s.charAt(i);
                number = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        new BasicCalculatorII().calculate(" 3/2 ");
    }
}
