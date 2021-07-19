package com.codeprac;

public class BinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBst(nums, 0, nums.length - 1);
    }

    private TreeNode buildBst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        var mid = (right + left) / 2 ;


        var root = new TreeNode(nums[mid]);
        root.left = buildBst(nums, left, mid - 1);
        root.right = buildBst(nums, mid + 1, right);

        return root;
    }
}
