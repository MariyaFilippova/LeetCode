import java.util.Arrays;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            chars[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']--;
        }
        return Arrays.stream(chars).allMatch(a -> a <= 0);
    }
}
