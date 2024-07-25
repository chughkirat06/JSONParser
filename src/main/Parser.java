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

    private boolean parseValue() {
        switch (currentToken) {
            case QUOTE:
                lexar.parseString();
                advance();
                return true;
            case NUMBER:
                lexar.parseNumber();
                advance();
                return true;
            case TRUE:
                advance();
                return true;
            case FALSE:
                advance();
                return true;
            case NULL:
                advance();
                return true;
            default:
                System.out.println("Unexpected token: " + currentToken);
                return false;
        }
    }

    private boolean parseKeyValuePair() {
        if (currentToken == Tokens.QUOTE) {
            lexar.parseString();
            advance();
            if (currentToken == Tokens.SEMI_COLON) {
                advance();
                if (parseValue()) {
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
                    advance();
                    return true;
                }
            }
        }
        return false;
    }
}
