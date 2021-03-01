public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int windowStart = 0;
        int[] chars = new int[26];
        int max = 0;
        int windowEnd = 0;
        for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            max = Math.max(max, ++chars[s.charAt(windowEnd) - 'A']);
            while (windowEnd - windowStart - max + 1 > k) {
                chars[s.charAt(windowStart++) - 'A']--;
            }
        }
        return windowEnd - windowStart;
    }
}
