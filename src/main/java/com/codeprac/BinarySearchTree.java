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

    public TreeNode fromArray(Integer[] array) {
        var root = new TreeNode(array[0]);
        buildBstFromArray(array, root, 1);
        return root;
    }

    private void buildBstFromArray(Integer[] array, TreeNode root, int index) {
        if (root == null || (index + 1) >= array.length) return;

        var leftValue = array[index];
        var rightValue = array[index + 1];

        if (leftValue != null) {
            root.left = TreeNode.of(leftValue);
            buildBstFromArray(array, root.left, index + 2);
        }

        if (rightValue != null) {
            root.right = TreeNode.of(rightValue);
            var rightIndex = leftValue == null ? index + 2 : index + 4;
            buildBstFromArray(array, root.right, rightIndex);
        }
    }
}
