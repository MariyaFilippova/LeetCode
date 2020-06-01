import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", n, 0, 0);
        return res;
    }

    void backtrack(List<String> res, String s, int max, int open, int close) {
        if (s.length() == 2*max) {
            res.add(s);
            return;
        }
        if (open < max) {
            backtrack(res, s + '(', max, open + 1, close);
        }
        if (close < open) {
            backtrack(res, s + ')', max, open, close + 1);
        }
    }

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3);
    }
}
