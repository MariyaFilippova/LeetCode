import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.reverse;

public class CarpRabin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.next();
        String s = scanner.next();
        List<Integer> occ = CarpRabin.RabinKarp(s, pattern);
        for (int i : occ) {
            System.out.print(i + " ");
        }
    }
    public static long charToLong(char ch) {
        return (long)(ch - 'A' + 1);
    }

    public static List<Integer> RabinKarp(String text, String pattern) {
        int a = 53;
        long m = 1_000_000_000 + 9;
        long patternHash = 0;
        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += charToLong(pattern.charAt(i)) * pow;
            patternHash %= m;

            currSubstrHash += charToLong(text.charAt(text.length() - pattern.length() + i)) * pow;
            currSubstrHash %= m;

            if (i != pattern.length() - 1) {
                pow = pow * a % m;
            }
        }


        ArrayList<Integer> occurrences = new ArrayList<>();

        for (int i = text.length(); i >= pattern.length(); i--) {
            if (patternHash == currSubstrHash) {
                boolean patternIsFound = true;

                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i - pattern.length() + j) != pattern.charAt(j)) {
                        patternIsFound = false;
                        break;
                    }
                }

                if (patternIsFound) {
                    occurrences.add(i - pattern.length());
                }
            }

            if (i > pattern.length()) {
                currSubstrHash = (currSubstrHash - charToLong(text.charAt(i - 1)) * pow % m + m) * a % m;
                currSubstrHash = (currSubstrHash + charToLong(text.charAt(i - pattern.length() - 1))) % m;
            }
        }

        reverse(occurrences);
        return occurrences;
    }
}
