import kotlin.math.pow

class Solution {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        if(root.left == null && root.right == null) return 1

        val maxH = root.maxHeight
        var ret = 2.0.pow(maxH).toInt() - 1

        var cur = root
        for (curH in 0 until maxH - 1) {
            if (cur == null) break
            if (!cur.left!!.isChildNodeExistAtHeight(curH, maxH)) cur = cur.left
            else {
                cur = cur.right
                ret += 2.0.pow(maxH - (curH + 1)).toInt()
            }
        }
        if (cur?.left != null) ret++
        if (cur?.right != null) ret++
        return ret
    }

    private fun TreeNode.isChildNodeExistAtHeight(startH: Int, destH: Int): Boolean {
        var curH = startH
        var cur: TreeNode? = this
        while (curH < destH) {
            if (cur == null) return false
            cur = cur.right
            curH++
        }
        return true
    }

    private val TreeNode.maxHeight: Int
        get() {
            var maxHeight = -1
            var cur: TreeNode? = this
            while (cur != null) {
                maxHeight++
                cur = cur.left
            }
            return maxHeight
        }
}