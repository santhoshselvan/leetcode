package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiameterOfBinaryTreeTest {

    @Test
    void shouldFindDiameter() {
        var diameterOfBinaryTree = new DiameterOfBinaryTree();

        assertEquals(3, diameterOfBinaryTree.diameterOfBinaryTree(
                new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))));

        assertEquals(1, diameterOfBinaryTree.diameterOfBinaryTree(
                new TreeNode(1, new TreeNode(2), null)));
    }
}
