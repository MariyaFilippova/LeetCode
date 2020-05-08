

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    int index;
    int val;

    Position(int index, int val) {
        this.index = index;
        this.val = val;
    }

}

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(start, arr[start]));
        int p = arr[start];
        while (!queue.isEmpty() && p != 0) {
            int val = queue.peek().val;
            int i = queue.poll().index;
            visited[i] = true;
            p = val;
            if (i + val < n && !visited[i + val]) {
                queue.add(new Position(i + val, arr[i + val]));
            }
            if (i - val >= 0 && !visited[i - val]) {
                queue.add(new Position(i - val, arr[i - val]));
            }
        }
        return p == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        new JumpGameIII().canReach(arr, s);
    }
}
