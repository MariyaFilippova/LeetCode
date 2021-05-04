import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsll {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> ends = new PriorityQueue<>((a, b) -> a - b);
        int rooms = 0;
        for (int [] interval : intervals) {
            if (ends.isEmpty()) {
                ends.add(interval[1]);
                rooms++;
                continue;
            }
            int end = ends.peek();
            if (end > interval[0]) {
                rooms++;
            }
            else {
                ends.poll();
            }
            ends.add(interval[1]);
        }
        return rooms;
    }

    public static void main(String[] args) {
        new MeetingRoomsll().minMeetingRooms(new int[][]
                {{2,15},{36,45},{9,29},{16,23},{4,9}});
    }
}
