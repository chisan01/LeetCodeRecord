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
    
    public boolean dfs(TreeNode curNode, int targetSum, int curSum) {
        curSum += curNode.val;
        
        if(curNode.left == null && curNode.right == null) {
            return (curSum == targetSum);
        }
        
        if(curNode.left != null) {
            if(dfs(curNode.left, targetSum, curSum)) return true;
        }
        
        if(curNode.right != null) {
            if(dfs(curNode.right, targetSum, curSum)) return true;
        }
        
        return false;
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, targetSum, 0);
    }
}