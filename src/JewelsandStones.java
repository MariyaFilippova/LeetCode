
import java.util.HashSet;
import java.util.Scanner;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hs = new HashSet<>();
        for(char c:J.toCharArray())
            hs.add(c);

        int cnt = 0;
        for(char c:S.toCharArray()){
            if(hs.contains(c))
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String J = scanner.nextLine();
        String S = scanner.nextLine();
        System.out.println(new JewelsandStones().numJewelsInStones(J, S));
    }
}
