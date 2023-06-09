class CreateBinaryTreeFromDescriptions {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val map = HashMap<Int, TreeNode>()
        val parents = HashSet<Int>()
        val children = HashSet<Int>()
        for (description in descriptions) {
            val p = description[0]
            val c = description[1]
            parents.add(p)
            children.add(c)
            val node = map.getOrPut(p) {TreeNode(p)}
            val child = map.getOrPut(c) {TreeNode(c)}
            if (description[2] == 0) {
                node.right = child
            }
            else {
                node.left = child
            }
        }
        parents.removeAll(children)
        return map[parents.first()]
    }
}