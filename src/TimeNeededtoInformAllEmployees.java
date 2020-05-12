import java.util.ArrayList;

import static java.lang.Math.max;

public class TimeNeededtoInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                children[manager[i]].add(i);
            }
        }
        return dfs(children, informTime, headID);
    }

    public int dfs(ArrayList<Integer>[] children, int[] informTime, int v) {
        if (children[v].isEmpty()) {
            return 0;
        }
        int time = informTime[v];
        int max = 0;
        for (int i: children[v]) {
            max = max(max, dfs(children, informTime, i));
        }
        return max + time;
    }

    public static void main(String[] args) {
        int n = 15;
        int[] manager = new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] infoTime = new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        new TimeNeededtoInformAllEmployees().numOfMinutes(n, 0, manager, infoTime);
    }
}