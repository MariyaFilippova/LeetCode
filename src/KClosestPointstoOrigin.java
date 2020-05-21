import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> q = new PriorityQueue<int []>((a, b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1] );
        for (int [] point: points) {
            q.add(point);
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[K - 1] = q.poll();
            K--;
        }
        return res;
    }
}
