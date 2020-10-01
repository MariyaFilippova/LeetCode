import java.util.Stack;

public class ScoreofParentheses {
    public int scoreOfParentheses(String S) {
        int score = 0;
        int opened = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                opened++;
            }
            else {
                opened--;
                if (S.charAt(i - 1) == '(') {
                    score += Math.pow(2, opened);
                }
            }
        }
        return score;
    }
}
