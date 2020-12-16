public class ValidateBST {
    class Solution {
        public boolean check(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }
            return check(node.left, min, node.val) && check(node.right, node.val, max);
        }

        public boolean isValidBST(TreeNode root) {
            return check(root, -21474836480L, 21474836470L);
        }

    }
}
