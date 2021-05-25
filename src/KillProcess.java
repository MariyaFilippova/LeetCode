import java.util.*;

public class KillProcess {
    HashMap<Integer, List<Integer>> parents = new HashMap<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < pid.size(); i++) {
            if (ppid.get(i) == 0) {
                continue;
            }
            List<Integer> children = parents.getOrDefault(ppid.get(i), new ArrayList<>());
            children.add(pid.get(i));
            parents.put(ppid.get(i), children);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            if (parents.containsKey(node)) {
                queue.addAll(parents.get(node));
            }
        }
        return res;
    }
}
