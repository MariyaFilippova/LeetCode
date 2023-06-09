import java.util.*
import kotlin.collections.ArrayList

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 */
class ReverseOddLevelsOfBinaryTree {
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        val queue: Deque<TreeNode> = LinkedList()
        val oddVals: ArrayList<List<Int>> = arrayListOf()

        queue.add(root)
        var level = 0;
        while (!queue.isEmpty()) {
            val list : ArrayList<Int> = arrayListOf()
            var size = queue.size
            while(size > 0) {
                val node = queue.poll()
                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
                if (level % 2 != 0) {
                    list.add(node.`val`)
                }
                size--
            }
            if (level % 2 != 0) {
                oddVals.add(list)
            }
            level++
        }

        queue.add(root)
        level = 0;
        while (!queue.isEmpty()) {
            var size = queue.size
            while (size > 0) {
                val node = queue.poll()
                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
                if (level % 2 != 0) {
                    node.`val` = oddVals[level/2][size - 1]
                }
                size--
            }
            level++
        }
        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}