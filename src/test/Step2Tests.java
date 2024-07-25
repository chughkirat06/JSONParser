package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.*;

public class Step2Tests {
    private Lexar lexar;
    private Parser parser;

    @Test
    public void testValidJson() {
        App.readJsonFile("src\\test\\step2\\valid.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }

    @Test
    public void testInvalidJson() {
        App.readJsonFile("src\\test\\step2\\invalid.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

    @Test
    public void testValid2Json() {
        App.readJsonFile("src\\test\\step2\\valid2.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }

    @Test
    public void testInvalid2Json() {
        App.readJsonFile("src\\test\\step2\\invalid2.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

    @Test
    public void testEscapedCharactersJson() {
        App.readJsonFile("src\\test\\step2\\escaped_characters.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }

    @Test
    public void testExtraCommaJson() {
        App.readJsonFile("src\\test\\step2\\extra_comma.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

    @Test
    public void testIncorrectQuotesJson() {
        App.readJsonFile("src\\test\\step2\\incorrect_quotes.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

    @Test
    public void testMissingValueJson() {
        App.readJsonFile("src\\test\\step2\\missing_value.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

    @Test
    public void testWhitespaceJson() {
        App.readJsonFile("src\\test\\step2\\whitespace.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }
}
