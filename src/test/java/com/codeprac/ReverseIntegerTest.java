package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    @Test
    void shouldReverseANumber() {

        var reverseInteger = new ReverseInteger();
        assertEquals(321, reverseInteger.reverse(123));
        assertEquals(-321, reverseInteger.reverse(-123));
        assertEquals(21, reverseInteger.reverse(120));
        assertEquals(0, reverseInteger.reverse(0));
        assertEquals(0, reverseInteger.reverse((int) (Math.pow(2, 31) - 1)));
        assertEquals(0, reverseInteger.reverse((int) (Math.pow(2, 31) - 1) * -1));
    }
}
