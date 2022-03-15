public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1;
        int h = x;
        while (l < h) {
            int mid = l + (h - l)/2;
            if (mid <= x/mid && (mid + 1) > x / (mid + 1)) return mid;
            if (mid > x/mid) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
