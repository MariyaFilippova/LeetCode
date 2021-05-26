public class InorderSuccessorinBSTll {
    public Node inorderSuccessor(Node x) {
        if (x.right != null) {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }

        while (x.parent != null && x == x.parent.right) {
            x = x.parent;
        }
        return x.parent;
    }
}
