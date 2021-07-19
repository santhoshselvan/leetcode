package com.codeprac;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        var leftHeight = diameterOfBinaryTreeHelper(root.left);
        var rightHeight = diameterOfBinaryTreeHelper(root.right);
        return leftHeight + rightHeight;
    }

    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) return 0;
        var leftHeight = diameterOfBinaryTreeHelper(root.left);
        var rightHeight = diameterOfBinaryTreeHelper(root.right);

        System.out.println( root + ": left " + leftHeight);
        System.out.println(root + ": right " + rightHeight);
        var height = Math.max(leftHeight, rightHeight);

        return height + 1;
    }
}

