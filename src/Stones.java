import java.util.PriorityQueue;
import java.util.Scanner;

class Stones {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> st = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st.add(-stones[i]);
        }
        while(st.size() > 1) {
            int a = st.poll();
            int b = st.poll();
            if (a != b) {
                st.add(a - b);
            }
        }
        if (st.size() == 0) {
            return 0;
        }
        return -st.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = scanner.nextInt();
        }
        new Stones().lastStoneWeight(stones);
    }
}
