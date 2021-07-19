package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationOfAPhoneNumberTest {

    @Test
    void shouldReturnLetterCombinations() {
        assertEquals(
                of("ad","ae","af","bd","be","bf","cd","ce","cf"),
                new LetterCombinationOfAPhoneNumber().findCombinations("23"));

        assertEquals(
                of("aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc"),
                new LetterCombinationOfAPhoneNumber().findCombinations("22"));

        assertEquals(
                of("adp", "adq", "adr", "ads", "aep", "aeq", "aer", "aes", "afp", "afq", "afr", "afs", "bdp", "bdq", "bdr", "bds", "bep", "beq", "ber", "bes", "bfp", "bfq", "bfr", "bfs", "cdp", "cdq", "cdr", "cds", "cep", "ceq", "cer", "ces", "cfp", "cfq", "cfr", "cfs"),
                new LetterCombinationOfAPhoneNumber().findCombinations("237"));

        assertEquals(
                36,
                new LetterCombinationOfAPhoneNumber().findCombinations("237").size());


        assertEquals(
                of(),
                new LetterCombinationOfAPhoneNumber().findCombinations(""));

        assertEquals(
                of("a", "b", "c"),
                new LetterCombinationOfAPhoneNumber().findCombinations("2"));

        assertEquals(
                11664,
                new LetterCombinationOfAPhoneNumber().findCombinations("23456789").size());
    }
}
