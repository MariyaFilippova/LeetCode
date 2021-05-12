import java.util.List;

public class LeftmostColumnwithatLeastaOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int n = binaryMatrix.dimensions().get(0);
        int m = binaryMatrix.dimensions().get(1);
        int i = 0;
        int j = m - 1;
        int counter = 0;
        while (i < n) {
            if (j < 0 && counter > 0) {
                return 0;
            }
            if (binaryMatrix.get(i, j) == 0) {
                i++;
            } else {
                counter++;
                j--;
            }
        }
        return counter == 0 ? -1 : j + 1;
    }
}


// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation
interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}
