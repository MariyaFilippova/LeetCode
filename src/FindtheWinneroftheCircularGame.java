import java.util.LinkedList;

public class FindtheWinneroftheCircularGame {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> friends = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        int position = 0;
        while (friends.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                position++;
                position = position %  friends.size();
            }
            friends.remove(position);
        }
        return friends.get(0);
    }
}
