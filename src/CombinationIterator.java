import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    final String characters;
    final int length;
    List<String> combinations;
    int cursor = 0;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.length = combinationLength;
        this.combinations = new ArrayList<>();
        generateCombinations(new StringBuilder(), 0);
    }

    public String next() {
        return combinations.get(cursor++);
    }

    public boolean hasNext() {
        return cursor < combinations.size();
    }

    public void generateCombinations(StringBuilder stringBuilder, int start) {
        if (stringBuilder.length() == length) {
            combinations.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < characters.length(); i++) {
            stringBuilder.append(characters.charAt(i));
            generateCombinations(new StringBuilder(stringBuilder), i + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
