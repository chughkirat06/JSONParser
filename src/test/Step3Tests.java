package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.*;

public class Step3Tests {
    private Lexar lexar;
    private Parser parser;

    @Test
    public void testValidJson() {
        App.readJsonFile("src\\test\\step3\\valid.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parseObject();
        assertTrue(isValid);
    }

    @Test
    public void testInvalidJson() {
        App.readJsonFile("src\\test\\step3\\invalid.json");
        lexar = new Lexar();
        parser = new Parser(lexar);
        boolean isValid = parser.parseObject();
        assertFalse(isValid);
    }
}
