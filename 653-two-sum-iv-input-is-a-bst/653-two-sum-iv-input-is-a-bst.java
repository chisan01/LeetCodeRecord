class Solution {

    TreeNode root;

    public boolean find(TreeNode cur, int num) {
        if (cur == null) return false;
        if (cur.val == num) return true;
        else if (cur.val < num) return find(cur.right, num);
        else return find(cur.left, num);
    }

    public boolean searchAll(TreeNode cur, int targetSum) {
        if (cur == null) return false;

        if ((cur.val * 2 != targetSum) && find(root, targetSum - cur.val)) {
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