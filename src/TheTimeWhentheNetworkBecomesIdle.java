import java.util.*;

public class TheTimeWhentheNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        ArrayList<Integer>[] map = new ArrayList[patience.length];
        for ( int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        int time = 0;
        int level = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int vertex = queue.poll();
                if (visited.add(vertex)) {
                    if (vertex != 0) {
                        int extraPayload = (level * 2 - 1) / patience[vertex];
                        int lastOut = extraPayload * patience[vertex];
                        time = Math.max(time, level * 2 + lastOut);
                    }
                    for (int connected : map[vertex]) {
                        if (!visited.contains(connected)) {
                            queue.add(connected);
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return time + 1;
    }


    public static void main(String[] args) {
        new TheTimeWhentheNetworkBecomesIdle().networkBecomesIdle(new int[][]{{0,1},{0,2},{1,2}}, new int[]{0,10,10});
    }
}
