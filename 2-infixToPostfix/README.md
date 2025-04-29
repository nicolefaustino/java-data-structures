# Infix to Postfix Expression Converter

This Java program converts infix arithmetic expressions to postfix notation (Reverse Polish Notation) using a stack-based algorithm.

## Features

- Converts standard infix expressions (with operators +, -, *, /, $) to postfix notation
- Handles operator precedence correctly:
  - `$` (exponentiation) has highest precedence (5)
  - `*` and `/` have medium precedence (4)
  - `+` and `-` have lowest precedence (1)
- Supports parentheses for grouping expressions
- Includes input validation for invalid characters

## Implementation Details

### Key Components

1. **Stack Operations**:
   - `push()`: Adds an element to the stack
   - `pop()`: Removes and returns the top element from the stack

2. **Precedence Check**:
   - `preced()`: Returns the precedence level of operators

3. **Conversion Algorithm**:
   - `infixToPostfix()`: The core conversion function that processes the infix expression

### Data Structures

- Uses array-based stack implementation
- Fixed stack size (SIZE = 10) - can be modified for larger expressions
- Character arrays for input (infix) and output (postfix) expressions

## How It Works

1. The program reads an infix expression from the user
2. Processes each character:
   - Operands are directly added to the output
   - Operators are pushed to the stack according to precedence rules
   - Parentheses are handled specially (push '(' and pop until '(' for ')')
3. Finally, any remaining operators in the stack are popped to the output
