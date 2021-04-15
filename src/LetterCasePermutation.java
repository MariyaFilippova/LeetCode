import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> strings = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        backtrack(S.toCharArray(), 0);
        return strings;
    }

    void backtrack(char [] chars, int i) {
        if (i == chars.length - 1) {
            strings.add(new String(chars));
            return;
        }
        if (Character.isDigit(chars[i])) {
            backtrack(chars, i+1);
            return;
        }
        chars[i] = Character.toLowerCase(chars[i]);
        backtrack(chars, i + 1);

        chars[i] = Character.toUpperCase(chars[i]);
        backtrack(chars, i + 1);
    }
}
