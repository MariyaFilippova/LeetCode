import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if ( i == 0 ) {
                diff = arr[i + 1] - arr[i];
            }
            else {
                if (diff != arr[i + 1] - arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
