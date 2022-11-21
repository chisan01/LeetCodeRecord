/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

import java.util.*

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return listOf()

        val result = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val curLevelNodes = mutableListOf<Int>()
            val numOfCurLevelNodes = queue.size
            repeat(numOfCurLevelNodes) {
                val curNode = queue.poll()
                curLevelNodes.add(curNode.`val`)
                curNode.left?.let { queue.add(it)}
                curNode.right?.let { queue.add(it)}
            }
            result.add(curLevelNodes.toList())
        }
        return result.toList()
    }
}