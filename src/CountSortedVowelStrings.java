public class CountSortedVowelStrings {
    int res;

    public int countVowelStrings(int n) {
        char[] vowels = new char[5];
        vowels[0] = 'a';
        vowels[1] = 'e';
        vowels[2] = 'i';
        vowels[3] = 'o';
        vowels[4] = 'u';

        backtrack(n, new StringBuilder(), vowels, 0);
        return res;
    }

    void backtrack(int n, StringBuilder stringBuilder, char[] vowels, int start) {
        if (stringBuilder.length() == n) {
            res++;
            return;
        }
        for (int i = start; i < vowels.length; i++) {
            StringBuilder sb = new StringBuilder(stringBuilder);
            sb.append(vowels[i]);
            backtrack(n, sb, vowels, i);
        }
    }
}
