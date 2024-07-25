package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.*;

public class Step5Tests {
    private Lexar lexar;
    private Parser parser;

    @Test
    public void testValid1Json() {
        App.readJsonFile("src\\test\\step5\\test_valid_1.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }

    @Test
    public void testInvalid1Json() {
        App.readJsonFile("src\\test\\step5\\test_invalid_1.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

    @Test
    public void testValid2Json() {
        App.readJsonFile("src\\test\\step5\\test_valid_2.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }

    @Test
    public void testInvalid2Json() {
        App.readJsonFile("src\\test\\step5\\test_invalid_2.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

}
