import java.util.*;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(i, codes[i]);
        }
        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                code.append(map.get(s.charAt(i)- 'a'));
            }
            set.add(code.toString());
        }
        return set.size();
    }
}
