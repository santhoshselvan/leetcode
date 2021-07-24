package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    void shouldFindLongestPalindromicSubstring() {
        var longestPalindromicSubstring = new LongestPalindromicSubstring();

//        assertEquals("bab", longestPalindromicSubstring.longestPalindrome("babad"));
//        assertEquals("a", longestPalindromicSubstring.longestPalindrome("a"));
//        assertEquals("a", longestPalindromicSubstring.longestPalindrome("ac"));
//        assertEquals("bobbob", longestPalindromicSubstring.longestPalindrome("bobbob"));
//        assertEquals("ddtattarrattatdd", longestPalindromicSubstring.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
        assertEquals("gykrkyg",
                longestPalindromicSubstring.longestPalindrome(
                        "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir"));

    }

    @Test
    void shouldFindPalindrome() {
        assertTrue( new LongestPalindromicSubstring().isPalindrome("bab"));
        assertTrue( new LongestPalindromicSubstring().isPalindrome("malayalam"));
        assertFalse( new LongestPalindromicSubstring().isPalindrome("baba"));
        assertFalse( new LongestPalindromicSubstring().isPalindrome("tamil"));
    }
}
