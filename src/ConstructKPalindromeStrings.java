import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int[] map = new int[26];
        for (char i : s.toCharArray()) {
            map[i - 'a']++;
        }
        int counter = 0;
        for (int i : map) {
            if (i % 2 != 0) {
                counter++;
            }
        }
        if (counter > k) {
            return false;
        }
        return true;
    }
}
