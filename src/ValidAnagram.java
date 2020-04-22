import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] fir = new char[s.length()];
        char[] sec = new char[t.length()];

        for (int i = 0; i < s.length(); i++) {
            fir[i] = s.charAt(i);
        }

        for (int j = 0; j < t.length(); j++) {
            sec[j] = t.charAt(j);
        }
        Arrays.sort(fir);
        Arrays.sort(sec);
        if (fir != sec) {
            return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        new ValidAnagram().isAnagram(s, t);

    }
}
