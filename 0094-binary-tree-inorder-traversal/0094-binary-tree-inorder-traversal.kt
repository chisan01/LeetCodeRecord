class Solution {
    fun f(curNode: TreeNode?, result: MutableList<Int>) {
        if(curNode == null) return
        curNode.left?.let { f(it, result) }
        result.add(curNode.`val`)
        curNode.right?.let { f(it, result) }
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        f(root, result)
        return result.toList()
    }
}