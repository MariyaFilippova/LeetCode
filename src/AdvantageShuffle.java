import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        class Element {
            int num;
            int index;

            Element(int num, int index) {
                this.index = index;
                this.num = num;
            }
        }
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Element(B[i], i));
        }
        list.sort((a, b) -> a.num - b.num);
        int i = 0;
        int j = 0;
        boolean[] used = new boolean[n];
        int[] res = new int[n];
        while (i < n && j < n) {
            if (A[i] > list.get(j).num) {
                res[j] = A[i];
                used[i] = true;
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (!used[i]) {
                res[j] = A[i];
                j++;
            }
        }
        int[] out = new int[n];
        for (i = 0; i < n; i++) {
            int index = list.get(i).index;
            out[index] = res[i];
        }
        return out;
    }
}
