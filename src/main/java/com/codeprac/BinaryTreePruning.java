package com.codeprac;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        traverseAndPrune(root);
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }

    private int traverseAndPrune(TreeNode root) {

        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return root.val;
        }

        var left = traverseAndPrune(root.left);
        var right = traverseAndPrune(root.right);
        if (left == 0) root.left = null;
        if (right == 0) root.right = null;


        return left + right + root.val;
    }
}
