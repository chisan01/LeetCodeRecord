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

    int targetSum;
    List<List<Integer>> answer = new ArrayList<>();
    Stack<Integer> curPath = new Stack<>();

    public void dfs(TreeNode cur, int curSum) {
        
        if(cur == null) return;

        curPath.add(cur.val);
        curSum += cur.val;
        
        if(cur.left == null && cur.right == null && curSum == targetSum) {
            answer.add(new ArrayList<>(curPath));
        }

        if(cur.left != null) dfs(cur.left, curSum);
        if(cur.right != null) dfs(cur.right, curSum);

        curPath.pop();
        curSum -= cur.val;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, 0);
        return answer;
    }
}