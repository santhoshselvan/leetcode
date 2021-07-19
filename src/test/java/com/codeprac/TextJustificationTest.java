package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextJustificationTest {

    @Test
    void shouldCreateLines() {

        var line1 = new TextJustification.Line(16);
        line1.addWord("This");
        line1.addWord("is");
        line1.addWord("an");
        var line2 = new TextJustification.Line(16);
        line2.addWord("example");
        line2.addWord("of");
        line2.addWord("text");
        var line3 = new TextJustification.Line(16);
        line3.addWord("justification.");

        assertEquals(List.of(line1, line2, line3), new TextJustification()
                .createLines(List.of("This", "is", "an", "example", "of", "text", "justification."), 16));

        var line11 = new TextJustification.Line(20);
        line11.addWord("everything");
        line11.addWord("else");
        line11.addWord("we");
        var line12 = new TextJustification.Line(20);
        line12.addWord("do");

        assertEquals(List.of(line11, line12), new TextJustification()
                .createLines(List.of("everything", "else", "we", "do"), 20));
    }

    @Test
    void shouldFormatLine() {
        var line = new TextJustification.Line(10);
        line.addWord("This");
        line.addWord("is");
        line.addWord("an");
        assertEquals("This is an", line.format());

        line = new TextJustification.Line(14);
        line.addWord("This");
        line.addWord("is");
        line.addWord("an");
        assertEquals("This   is   an", line.format());


        line = new TextJustification.Line(16);
        line.addWord("shall");
        line.addWord("be");
        assertEquals("shall be        ", line.format(true));
    }

    @Test
    void shouldJustifyText() {
        assertEquals(List.of(
                "This    is    an",
                "example  of text",
                "justification.  "),
                new TextJustification()
                        .fullJustify(List.of("This", "is", "an", "example", "of", "text", "justification."), 16));

        assertEquals(List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "),
                new TextJustification()
                        .fullJustify(List.of("What","must","be","acknowledgment","shall","be"), 16));

        assertEquals(List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "),
                new TextJustification()
                        .fullJustify(List.of("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"), 20));

        assertEquals(List.of(
                "ask   not   what",
                "your country can",
                "do  for  you ask",
                "what  you can do",
                "for your country"),
                new TextJustification()
                        .fullJustify(List.of("ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"), 16));
    }
}
