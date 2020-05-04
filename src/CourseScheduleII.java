import java.util.List;

public class CourseScheduleII {
    static final int inf = 1000000;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                matrix[i][j] = inf;
            }
        }
        for (int[] p: prerequisites) {
            matrix[p[0]][p[1]] = 1;
        }
        if (TopologicalSort.checkForCycle(matrix)) {
            return new int[0];
        }
        List<Integer> list = TopologicalSort.topologicalSort(matrix);
        int[] res = new int [list.size()];
        for (int i = 0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
