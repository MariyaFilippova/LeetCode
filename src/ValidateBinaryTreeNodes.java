import java.util.HashSet;
import java.util.Set;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> tree = new HashSet<>();
        for (int i = 0; i<n; i++) {
            if (leftChild[i] != -1 && !tree.add(leftChild[i])) {
                return false;
            }
            if (rightChild[i] != -1 && !tree.add(rightChild[i])) {
                return false;
            }
            if (leftChild[i] == -1 && rightChild[i] == -1 && !tree.isEmpty() && !tree.contains(i)) return false;
        }
        return tree.size() == n-1;
    }
}
