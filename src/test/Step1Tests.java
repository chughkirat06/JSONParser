package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.*;

public class Step1Tests {
    private Lexar lexar;
    private Parser parser;

    @Test
    public void testValidJson() {
        App.readJsonFile("src\\test\\step1\\valid.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertTrue(isValid);
    }

    @Test
    public void testInvalidJson() {
        App.readJsonFile("src\\test\\step1\\invalid.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parse();
        assertFalse(isValid);
    }

    @Test(expected = RuntimeException.class)
    public void testFileNotFound() {
        App.readJsonFile("src\\test\\step\\nonexistent.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        parser.parse();
    }
}
