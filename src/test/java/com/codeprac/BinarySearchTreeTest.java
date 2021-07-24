package com.codeprac;

import org.junit.jupiter.api.Test;

import static com.codeprac.TreeNode.of;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void shouldCreateBST() {
        var binarySearchTree = new BinarySearchTree();

        assertEquals(
                of(0, of(-10, null, of(-3)), of(5, null, of(9))),
                binarySearchTree.sortedArrayToBST(new int[] {-10,-3,0,5,9}));

        assertEquals(
                of(1, null, of(3)),
                binarySearchTree.sortedArrayToBST(new int[] {1,3}));
    }

    @Test
    void shouldCreateFromArray() {
        var bst = new BinarySearchTree();

        assertEquals(of(1, of(0), of(1)),
                bst.fromArray(new Integer[]{1, 0, 1}));


        assertEquals(of(1, of(0, of(2), of(3)), of(1)),
                bst.fromArray(new Integer[]{1, 0, 1, 2, 3}));


        assertEquals(of(1, null, of(0, of(0), of(1))),
                bst.fromArray(new Integer[]{1,null,0,0,1}));

        assertEquals(of(1, null, of(0, null, of(1))),
                bst.fromArray(new Integer[]{1,null,0,null,1}));

    }
}
