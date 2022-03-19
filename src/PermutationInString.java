import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int [] chars = new int[26];
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) return false;
        for (int i = 0; i < l1; i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        if (Arrays.stream(chars).allMatch(a -> a == 0)) return true;
        for (int i = l1; i < l2; i++) {
            chars[s2.charAt(i) - 'a']--;
            chars[s2.charAt(i - l1) - 'a']++;
            if (Arrays.stream(chars).allMatch(a -> a == 0)) return true;
        }
        return false;
    }



    public static void main(String[] args) {
        new PermutationInString().checkInclusion("hello", "ooolleoooleh");
    }
}
