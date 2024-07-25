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

    public boolean parseObject() {
        if (currentToken == Tokens.BRACE_OPEN) {
            advance();
            if (currentToken == Tokens.BRACE_CLOSE) {
                advance();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
