import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        int counter = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> keys = new LinkedList<>();
        int size = 0;
        keys.add("0000");
        visited.add("0000");
        for (String dead : deadends) {
            if (dead.equals("0000")) {
                return -1;
            }
            visited.add(dead);
        }
        while (!keys.isEmpty()) {
            size = keys.size();
            while (size != 0) {
                String key = keys.poll();
                if (key.equals(target)) {
                    return counter;
                }
                for (int i = 0; i < 4; i++) {
                    char c = key.charAt(i);
                    String s1 = key.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + key.substring(i + 1);
                    String s2 = key.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + key.substring(i + 1);
                    if (!visited.contains(s1)) {
                        keys.add(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2)) {
                        keys.add(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            counter++;
        }
        return -1;
    }
}
