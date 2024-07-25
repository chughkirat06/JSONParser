package main;

public class Parser {
    private Lexar lexar;
    private Tokens currentToken;

    public Parser(Lexar lexar) {
        this.lexar = lexar;
        this.currentToken = lexar.nextToken();
    }

    private void advance() {
        currentToken = lexar.nextToken();
    }

    private boolean parseKeyValuePair() {
        if (currentToken == Tokens.QUOTE) {
            String key = lexar.parseString();
            advance();
            if (currentToken == Tokens.SEMI_COLON) {
                advance();
                if (currentToken == Tokens.QUOTE) {
                    String value = lexar.parseString();
                    advance();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean parseObject() {
        if (currentToken == Tokens.BRACE_OPEN) {
            advance();
            if (parseKeyValuePair()) {
                while (currentToken == Tokens.COMMA) {
                    advance();
                    if (!parseKeyValuePair()) {
                        return false;
                    }
                }
                if (currentToken == Tokens.BRACE_CLOSE) {
                    return true;
                }
            }
        }
        return false;
    }

}
