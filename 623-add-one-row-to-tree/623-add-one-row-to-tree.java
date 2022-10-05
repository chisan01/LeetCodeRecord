/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int val, depth;
    
    void addNode(TreeNode cur) {
        TreeNode newLeft = new TreeNode(val, cur.left, null);
        TreeNode newRight = new TreeNode(val, null, cur.right);
        cur.left = newLeft;
        cur.right = newRight;
    }
    
    void dfs(TreeNode cur, int curDepth) {
        if(cur == null) return;
        if(curDepth == depth - 1) addNode(cur);
        else {
            dfs(cur.left, curDepth + 1);
            dfs(cur.right, curDepth + 1);
        }
    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.val = val;
        this.depth = depth;
        
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val, root, null);
            root = newRoot;
        } else dfs(root, 1);

        return root;
    }
}