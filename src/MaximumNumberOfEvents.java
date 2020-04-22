import java.util.*;

public class MaximumNumberOfEvents {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        HashSet<Integer> set = new HashSet<>();
        for (int[] e : events) {
            if (e[0] == e[1]) {
                set.add(e[0]);
            } else {
                for (int i = e[0]; i <= e[1]; i++) {
                    if (!set.contains(i)) {
                        set.add(i);
                        break;
                    }
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] events = new int[n][2];
        for (int i = 0; i < n; i++) {
            events[i][0] = scanner.nextInt();
            events[i][1] = scanner.nextInt();
        }
        new MaximumNumberOfEvents().maxEvents(events);
    }
}
