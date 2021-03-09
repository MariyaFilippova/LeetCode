import java.util.Stack;

public class SmallestSubsequenceofDistinctCharacters {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        int[] used = new int[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - 'a';
            if (used[current]++ > 0) {
                continue;
            }
            while (!stack.empty() && current < stack.peek() && lastIndex[stack.peek()] > i) {
                used[stack.pop()] = 0;
            }
            stack.push(current);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : stack) {
            stringBuilder.append((char) (i + 'a'));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new SmallestSubsequenceofDistinctCharacters().smallestSubsequence("abccab");
    }

}
