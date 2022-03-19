import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        Set<Character> chars = new HashSet<>();
        int max = 0;
        if (s.length() == 0) return 0;
        while (r < s.length()) {
            if (chars.contains(s.charAt(r))) {
                chars.remove(s.charAt(l));
                l++;
            }
            else {
                chars.add(s.charAt(r));
                r++;
                max = Math.max(max, r - l);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bccdfgss");
    }
}
