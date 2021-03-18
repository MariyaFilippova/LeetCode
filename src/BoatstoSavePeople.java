import java.util.Arrays;

public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0;
        int j = n - 1;
        int boats = 0;
        while (i <= j) {
            if (people[j] + people[i] <= limit) {
                j--;
                i++;
            }
            else {
                j--;
            }
            boats++;
        }
        return boats;
    }
}
