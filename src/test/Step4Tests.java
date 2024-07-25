package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.*;

public class Step4Tests {
    private Lexar lexar;
    private Parser parser;

    @Test
    public void testValidJson() {
        App.readJsonFile("src\\test\\step4\\valid.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }

    @Test
    public void testInvalidJson() {
        App.readJsonFile("src\\test\\step4\\invalid.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

    @Test
    public void testValid2Json() {
        App.readJsonFile("src\\test\\step4\\valid2.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }
}
