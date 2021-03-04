import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> (a[0] % 2147483646 - b[0] % 2147483646));
        int arrows = 1;
        int start = points[0][0];
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
            else {
                end = Math.min(end, points[i][1]);
            }
            start = points[i][0];
        }
        return arrows;
    }
}
