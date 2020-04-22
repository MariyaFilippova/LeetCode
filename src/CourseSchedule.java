import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int k = prerequisites.length;
        boolean[] hasntCycle = new boolean[numCourses];
        List<Set<Integer>> graph = new ArrayList();
        List<Set<Integer>> rgraph = new ArrayList();

        for (int i = 0; i < numCourses; ++i) {
            graph.add(new HashSet());
            rgraph.add(new HashSet());
        }
        for (int i = 0; i < k; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(u).add(v);
            rgraph.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++)  {
            if (graph.get(i).isEmpty()) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int j = queue.poll();
            hasntCycle[j] = true;
            for (int i: rgraph.get(j)) {
                graph.get(i).remove(j);
                if (graph.get(i).isEmpty())
                    queue.offer(i);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!hasntCycle[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] prerequisites = new int[k][2];
        for (int i = 0; i < k; i++) {
            prerequisites[i][0] = scanner.nextInt();
            prerequisites[i][1] = scanner.nextInt();
        }
        new CourseSchedule().canFinish(n, prerequisites);
    }
}
