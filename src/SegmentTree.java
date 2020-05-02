import java.util.Scanner;

import static java.lang.Math.log;

public class SegmentTree {
    int[] tree;
    int a[];
    int n;


    SegmentTree(int a[]) {
        int k = a.length << 1;
        tree = new int[k];
        this.a = a;
        this.n = a.length;
        build(a, n);
    }

    private void build(int[] a, int n) {
        for (int i = n; i < 2 * n; i++) {
            tree[i] = a[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }


    int getSum(int l, int r) {
        int res = 0;
        for (l += n, r += n; r >= l; l >>= 1, r >>= 1) {
            if ((l & 1) == 1)
                res += tree[l++];
            if ((r & 1) == 0)
                res += tree[r--];
        }
        return res;
    }

    void update(int index, int number) {
        tree[index + n] = number;
        for (index += n; index > 0; index >>= 1) {
            tree[index >> 1] = tree[index] + tree[index ^ 1];
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        SegmentTree tree = new SegmentTree(a);
        tree.build(a, n);
        tree.getSum(1, 4);
    }
}
