import java.util.HashSet;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int i: candyType) {
            set.add(i);
        }
        return Math.min(candyType.length/2, set.size());
    }
}
