import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    List<Integer> dig = new ArrayList<>();
    Map<Integer, String> map;
    List<StringBuilder> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map = new HashMap<Integer, String>() {{
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }};
        for (int i = 0; i < digits.length(); i++) {
            dig.add(digits.charAt(i) - '0');
        }
        backtrack(0, new StringBuilder());
        List<String> res = new ArrayList<>();
        for (StringBuilder s : list) {
            res.add(s.toString());
        }
        return res;
    }

    void backtrack(int start, StringBuilder s) {
        if (s.length() == dig.size()) {
            list.add(s);
            return;
        }
        for (int i = start; i < dig.size(); i++) {
            for (int j = 0; j < map.get(dig.get(i)).length(); j++) {
                backtrack(i + 1, new StringBuilder(s).append(map.get(dig.get(i)).charAt(j)));
            }
        }
    }
}
