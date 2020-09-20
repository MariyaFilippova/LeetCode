import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindandReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        Map<Character, Character> pw = new HashMap<>();
        Map<Character, Character> wp = new HashMap<>();

        for (String word : words) {
            boolean flag = false;
            if (word.length() != pattern.length()) {
                continue;
            }
            for (int i = 0; i < pattern.length(); i++) {
                char key = pattern.charAt(i);
                char value = word.charAt(i);
                if (pw.containsKey(key)) {
                    if (pw.get(key) != value) {
                        flag = true;
                        break;
                    }
                }
                if (wp.containsKey(value)) {
                    if (pw.get(value) != key) {
                        flag = true;
                        break;
                    }
                }
                pw.put(key, value);
                wp.put(value, key);
            }
            if (!flag) {
                res.add(word);
            }
            pw.clear();
            wp.clear();
        }
        return res;
    }
}
