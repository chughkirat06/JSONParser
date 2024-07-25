package main;

public enum Tokens {
    BRACE_OPEN('{'),
    BRACE_CLOSE('}'),
    BEGIN_ARRAY('['),
    END_ARRAY(']'),
    SEMI_COLON(':'),
    QUOTE('"'),
    COMMA(','),
    TRUE('t'),
    FALSE('f'),
    NULL('n'),
    STRING('s');

    private final char symbol;

    Tokens(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
