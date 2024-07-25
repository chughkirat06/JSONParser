package main;

public class Lexar {
    private StringBuilder jsonContent;
    private int position;
    private char currentChar;

    public Lexar() {
        this.position = 0;
        this.jsonContent = App.getJsonContent();
        this.currentChar = jsonContent != null && jsonContent.length() > 0 ? jsonContent.charAt(position) : '\0';
    }

    public void advance() {
        position++;
        if (position < jsonContent.length()) {
            currentChar = jsonContent.charAt(position);
        } else {
            currentChar = '\0';
        }
    }

    public void skipWhiteSpace() {
        while (Character.isWhitespace(currentChar)) {
            advance();
        }
    }

    public Tokens nextToken() {
        while (currentChar != '\0') {

            if (Character.isWhitespace(currentChar)) {
                skipWhiteSpace();
                continue;
            }

            switch (currentChar) {
                case '{':
                    advance();
                    return Tokens.BRACE_OPEN;
                case '}':
                    advance();
                    return Tokens.BRACE_CLOSE;
                case '[':
                    advance();
                    return Tokens.BEGIN_ARRAY;
                case ']':
                    advance();
                    return Tokens.END_ARRAY;
                case ':':
                    advance();
                    return Tokens.SEMI_COLON;
                case ',':
                    advance();
                    return Tokens.COMMA;
                case '"':
                    advance();
                    return Tokens.QUOTE;
                default:
                    if (Character.isLetterOrDigit(currentChar)) {
                        return Tokens.STRING;
                    } else {
                        System.out.println("Unexpected character");
                        return null;
                    }
            }
        }
        return null;
    }

    public String parseString() {
        StringBuilder str = new StringBuilder();
        // Skip opening quote
        if (currentChar == '"') {
            advance();
        }
        while (currentChar != '"' && currentChar != '\0') {
            if (currentChar == '\\') {
                advance();
                switch (currentChar) {
                    case 'n':
                        str.append('\n');
                        break;
                    case 't':
                        str.append('\t');
                        break;
                    case '"':
                        str.append('"');
                        break;
                    case '\\':
                        str.append('\\');
                        break;
                    default:
                        str.append('\\').append(currentChar);
                        break;
                }
            } else {
                str.append(currentChar);
            }
            advance();
        }
        // Skip closing quote
        if (currentChar == '"') {
            advance();
        }
        return str.toString();
    }
}
