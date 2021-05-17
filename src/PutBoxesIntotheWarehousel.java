import java.util.Arrays;

public class PutBoxesIntotheWarehousel {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int[] min = new int[warehouse.length];
        min[0] = warehouse[0];
        for (int k = 1; k < warehouse.length; k++) {
            min[k] = Math.min(warehouse[k], min[k - 1]);
        }
        int count = 0;

        for (int i = warehouse.length - 1; i >= 0; i--) {
            if (count < boxes.length && boxes[count] <= min[i]) {
                count++;
            }
        }
        return count;
    }
}
