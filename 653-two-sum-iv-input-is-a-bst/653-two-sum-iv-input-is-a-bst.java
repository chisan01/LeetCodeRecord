import java.util.*;

class Solution {

    TreeNode root;

    public Optional<TreeNode> find(TreeNode cur, int num) {
        if (cur == null) return Optional.empty();
        if (cur.val == num) return Optional.of(cur);
        else if (cur.val < num) return find(cur.right, num);
        else return find(cur.left, num);
    }

    public boolean searchAll(TreeNode cur, int targetSum) {
        if (cur == null) return false;

        Optional<TreeNode> treeNode = find(root, targetSum - cur.val);
        if (treeNode.isPresent() && treeNode.get() != cur) {
            return true;
        } else {
            if (searchAll(cur.left, targetSum)) return true;
            if (searchAll(cur.right, targetSum)) return true;
        }
        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        return searchAll(root, k);
    }
}