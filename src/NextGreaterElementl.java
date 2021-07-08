import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementl {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums2[nums2.length - 1], -1);
        for (int i = nums2.length - 2; i >= 0; i--) {
            int prev = nums2[i + 1];
            while (prev <= nums2[i] && prev != -1) {
                prev = map.get(prev);
            }
            map.put(nums2[i], prev);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new NextGreaterElementl().nextGreaterElement(new int[] {4,1,2}, new int [] {1,3,4,2});
    }
}
