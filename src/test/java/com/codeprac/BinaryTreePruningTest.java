package com.codeprac;

import org.junit.jupiter.api.Test;

import static com.codeprac.TreeNode.of;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePruningTest {

    @Test
    void shouldPruneBinaryTree() {
        var binaryTreePruning = new BinaryTreePruning();


        assertEquals(of(1, of(1), null),
                binaryTreePruning.pruneTree(of(1, of(1), of(0)))
        );

        assertEquals(of(1, null, of(0, null, of(1))),
                binaryTreePruning.pruneTree(of(1, null, of(0, of(0), of(1))))
                );

        assertEquals(of(1, null, of(1, null, of(1))),
                binaryTreePruning.pruneTree(of(1, of(0, of(0), of(0)), of(1, of(0), of(1))))
        );

        assertEquals(of(1, of(1, of(1), null), null),
                binaryTreePruning.pruneTree(of(1, of(1, of(1), null), null))
        );

        assertEquals(of(1, of(1, null, null), null),
                binaryTreePruning.pruneTree(of(1, of(1, of(0), null), null))
        );

        TreeNode left = of(1, of(1, of(0), null), of(1));
        TreeNode right = of(0, of(0), of(1));
        assertEquals(of(1, of(1, of(1), of(1)), of(0, null, of(1))),
                binaryTreePruning.pruneTree(of(1, left, right))
        );

        assertEquals(of(1), binaryTreePruning.pruneTree(of(1)));
        assertNull(binaryTreePruning.pruneTree(of(0)));

        assertNull(binaryTreePruning.pruneTree(of(0, null, of(0, of(0), of(0)))));
    }
}
