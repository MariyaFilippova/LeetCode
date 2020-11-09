import java.util.ArrayList;
import java.util.List;

public class ThekthLexicographicalStringofAllHappyStringsofLengthn {
    List<StringBuilder> list = new ArrayList<>();
    char[] set = new char[3];

    public String getHappyString(int n, int k) {
        set[0] = 'a';
        set[1] = 'b';
        set[2] = 'c';
        backtrack(n, new StringBuilder());
        return list.size() < k ? "" : list.get(k - 1).toString();
    }

    void backtrack(int n, StringBuilder string) {
        if (string.length() == n) {
            list.add(string);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (string.length() != 0 && set[i] == string.charAt(string.length() - 1)) {
                continue;
            }
            StringBuilder s = new StringBuilder(string);
            s.append(set[i]);
            backtrack(n, s);
        }
    }
}
