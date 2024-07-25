# Challenge 2 - Build Your Own JSON Parser

This project is part of the John Crickett Coding Challenges series. It involves building a custom JSON parser from scratch using Java. The parser is designed to handle various JSON structures, including objects, arrays, and nested elements, while validating the JSON format and managing both valid and invalid cases.

## Project Overview

The objective of this project is to create a robust JSON parser that can:
- Parse and validate JSON objects and arrays.
- Handle nested structures and various JSON data types.
- Provide meaningful error messages for invalid JSON formats.

## Key Features

- **Tokenizer Implementation:** Identifies and processes different JSON tokens, such as braces, brackets, colons, and commas.
- **Parser Design:** Handles nested JSON structures and various data types, including strings, numbers, booleans, and null values.
- **Error Handling:** Manages invalid JSON tokens and structures with clear error messages to enhance robustness.

## How It Works

1. **Reading JSON File:** The `App` class reads the content of a JSON file and processes it using the `Lexar` (tokenizer) and `Parser` (parser) classes.
2. **Tokenization:** The `Lexar` class tokenizes the input JSON content, identifying different JSON elements.
3. **Parsing:** The `Parser` class uses the tokens to validate and parse JSON objects and arrays, handling both valid and invalid cases.
