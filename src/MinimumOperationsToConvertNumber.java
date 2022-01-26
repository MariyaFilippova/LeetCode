import java.util.*;

public class MinimumOperationsToConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                int number = queue.poll();
                if (number == goal) return level;
                if (number > 1000 || number < 0 || visited.contains(number)) {
                    continue;
                }
                visited.add(number);
                for (int n : nums) {
                    queue.add(number - n);
                    queue.add(number + n);
                    queue.add(number^n);
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToConvertNumber().minimumOperations(new int[] {77,74,20}
        ,79, 92));
    }
}
