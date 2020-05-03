import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.min;

public class SegmentTree {

    private void build(int[] a, int n) {
        int[] tree = new int[n << 1];
        for (int i = n; i < 2 * n; i++) {
            tree[i] = a[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    private int[] buildRQM(int[] a, int n) {
        int[] tree = new int[n << 1];
        for (int i = n; i < 2 * n; i++) {
            tree[i] = a[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = min(tree[2 * i], tree[2 * i + 1]);
        }
        return tree;
    }

    int getMin(int l, int r, int n, int[] tree) {
        int oneSide = 21010011;
        int secSide = 21010011;
        for (l += n, r += n; r >= l; l >>= 1, r >>= 1) {
            if ((l & 1) == 1)
                oneSide = tree[l++];
            if ((r & 1) == 0)
                secSide = tree[r--];
        }
        return min(oneSide, secSide);
    }


    int getSum(int l, int r, int n, int[] tree) {
        int res = 0;
        for (l += n, r += n; r >= l; l >>= 1, r >>= 1) {
            if ((l & 1) == 1)
                res += tree[l++];
            if ((r & 1) == 0)
                res += tree[r--];
        }
        return res;
    }

    void update(int index, int number, int n, int[] tree) {
        tree[index + n] = number;
        for (index += n; index > 0; index >>= 1) {
            tree[index >> 1] = tree[index] + tree[index ^ 1];
        }
    }

    public List<Integer> countSmaller(int[] a) {
        int n = a.length;
        List<Integer> list = new ArrayList<>();
        int[] tree = buildRQM(a, n);
        for (int i = 0; i< n; i++) {
            list.add(getMin(i, n-1, n, tree));
        }
        return list;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        SegmentTree tree = new SegmentTree();
        tree.countSmaller(a);
    }
}
