import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumNumberofVerticestoReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Set<Integer>> e = new ArrayList<>();
        for (int i = 0; i < n;i++) {
            e.add(new HashSet<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int dst = edges.get(i).get(0);
            int src = edges.get(i).get(1);
            e.get(src).add(dst);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).size() == 0) {
                leaves.add(i);
            }
        }
        return leaves;
    }
}
