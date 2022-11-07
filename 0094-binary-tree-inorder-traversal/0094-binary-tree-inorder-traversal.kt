class Solution {
    fun f(curNode: TreeNode?, result: MutableList<Int>) {
        if(curNode == null) return
        f(curNode.left, result)
        result.add(curNode.`val`)
        f(curNode.right, result)
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        f(root, result)
        return result.toList()
    }
}