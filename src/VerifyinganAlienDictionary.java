import java.util.HashMap;
import java.util.Map;

public class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            alphabet.put(order.charAt(i), i);
        }
        if (words.length == 0) {
            return true;
        }
        int position = alphabet.get(words[0].charAt(0));
        for (int i = 1; i < words.length; i++) {
            int position_next = alphabet.get(words[i].charAt(0));
            if (position > position_next) {
                return false;
            }
            if (position == position_next) {
                int j = 1;
                int length_first = words[i - 1].length();
                int length_second = words[i].length();
                if (j == length_second &&  length_second != length_first) {
                    return false;
                }
                if (j == length_first) {
                    continue;
                }
                int a = alphabet.get(words[i].charAt(1));
                int b = alphabet.get(words[i - 1].charAt(1));
                while (j < Math.min(length_first, length_second) && a == b) {
                    a = alphabet.get(words[i].charAt(j));
                    b = alphabet.get(words[i - 1].charAt(j));
                    j++;
                }
                if (a < b) {
                    return false;
                }
                if (j == length_second && length_second != length_first && a == b) {
                    return false;
                }
            }
            position = position_next;
        }
        return true;
    }
}
