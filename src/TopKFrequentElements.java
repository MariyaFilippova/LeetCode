import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            q.add(e);
        }
        for (int i = 0; i < k; i++) {
            res.add(q.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums  = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new TopKFrequentElements().topKFrequent(nums, k);
    }
}
