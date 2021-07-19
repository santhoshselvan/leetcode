package com.codeprac;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }

    private boolean traverse(TreeNode root) {
        if (root == null) return true;
        boolean leftResult = traverse(root.left) && root.left != null ? root.val > root.left.val : true;
        boolean rightResult = traverse(root.right) && root.right != null ? root.val < root.right.val: true;


        return leftResult && rightResult;
    }
}
