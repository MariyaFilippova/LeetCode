import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        for (int[] p : prerequisites) {
            connected[p[0]][p[1]] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (connected[j][i] && connected[i][k]) {
                        connected[j][k] = true;
                    }
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int [] q : queries) {
            res.add(connected[q[0]][q[1]]);
        }
        return res;
    }
}
