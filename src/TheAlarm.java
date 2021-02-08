import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TheAlarm {
    static  int counter;
    static  int connected;
    static  ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int towers = scanner.nextInt();
        int[][] dist = new int[towers][3];
        for (int i = 0; i < towers; i++) {
            for (int j = 0; j < 3; j++) {
                dist[i][j] = scanner.nextInt();
            }
        }
        ArrayList[] list = new ArrayList[towers];
        for (int i = 0; i < towers; i++) {
            list[i] = new ArrayList();
            for (int j = 0; j < towers; j++) {
                if (j != i && Math.sqrt((dist[i][0] - dist[j][0]) * (dist[i][0] - dist[j][0]) + (dist[i][1] - dist[j][1]) * (dist[i][1] - dist[j][1])) < dist[i][2]) {
                    list[i].add(j);
                }
            }
        }
        generateCombinations(towers, new ArrayList<>(), 0);
        for (ArrayList<Integer> arrayList: combinations) {
            boolean[] visited = new boolean[towers];
            for (int i = 0; i < arrayList.size(); i++) {
                dfs(arrayList.get(i), visited, list);
            }
            if (connected == towers) {
                counter++;
            }
            connected = 0;
        }
        System.out.println(counter);
    }

    static void generateCombinations(int n, ArrayList<Integer> list, int start) {
        for (int i = start; i < n; i++) {
            list.add(i);
            combinations.add(new ArrayList<Integer>(list));
            generateCombinations(n, list, i+1);
            list.remove(list.size() - 1);
        }
    }

    static void dfs(int v, boolean[] visited, ArrayList[] list) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        connected++;
        for (int j = 0; j < list[v].size(); j++) {
            dfs((int)list[v].get(j), visited, list);
        }
    }
}
