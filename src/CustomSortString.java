import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        Comparator<Character> comparator = (o1, o2) -> {
            if (map.containsKey(o1) && map.containsKey(o2)) {
                return map.get(o1) - map.get(o2);
            }
            if (!map.containsKey(o1)) {
                return -1;
            }
            if (!map.containsKey(o2)) {
                return 1;
            }
            return 0;
        };

        PriorityQueue<Character> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("cbafg","abcd"));
    }
}
