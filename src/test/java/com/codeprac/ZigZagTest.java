package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagTest {

    @Test
    void shouldConstructZigZap() {
        var zigZag = new ZigZag();

        assertEquals("PAHNAPLSIIGYIR",
                zigZag.convert("PAYPALISHIRING", 3));

        assertEquals("PINALSIGYAHRPI",
                zigZag.convert("PAYPALISHIRING", 4));

        assertEquals("A",
                zigZag.convert("A", 1));

        assertEquals("AB",
                zigZag.convert("AB", 1));

        assertEquals("AB",
                zigZag.convert("AB", 2));

        assertEquals("SNHSATOH",
                zigZag.convert("SANTHOSH", 2));
    }
}
