package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBSTTest {

    @Test
    void shouldValidateBST() {
        var validateBST = new ValidateBST();

        assertTrue(validateBST.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

        assertFalse(validateBST.isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
        assertFalse(validateBST.isValidBST(new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
    }
}
