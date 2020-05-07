import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] key = new int[rooms.size()];
        dfs(rooms, 0, key);
        return Arrays.stream(key).allMatch(a -> a==1);
    }

    public void dfs(List<List<Integer>> rooms, int v, int[] key) {
        key[v] = 1;
        for (int i : rooms.get(v)) {
            if (key[i] != 1)
                dfs(rooms, i, key);
        }
    }
}
