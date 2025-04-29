import java.util.Scanner;

public class infixToPostix {
    static final int SIZE = 10;

    public static void push(char[] s, char symbol, int[] top) {
        s[++top[0]] = symbol;
    }

    public static char pop(char[] s, int[] top) {
        return s[top[0]--];
    }

    public static int preced(char symbol) {
        switch (symbol) {
            case '$':
                return 5;
            case '/':
            case '*':
                return 4;
            case '+':
            case '-':
                return 1;
            default:
                return 0; // Added a default return value
        }
    }

    public static int infixToPostfix(char[] infix, char[] postfix) {
        int i, j = 0;
        int[] top = {-1};
        char[] s = new char[SIZE];
        char symbol, temp;

        for (i = 0; i < infix.length; i++) {
            symbol = infix[i];
            if (Character.isLetterOrDigit(symbol))
                postfix[j++] = symbol;
            else {
                switch (symbol) {
                    case '(':
                        push(s, symbol, top);
                        break;
                    case ')':
                        temp = pop(s, top);
                        while (temp != '(') {
                            postfix[j++] = temp;
                            temp = pop(s, top);
                        }
                        break;
                    case '$':
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        if (top[0] == -1 || s[top[0]] == '(')
                            push(s, symbol, top);
                        else {
                            while (top[0] != -1 && preced(s[top[0]]) >= preced(symbol) && s[top[0]] != '(')
                                postfix[j++] = pop(s, top);
                            push(s, symbol, top);
                        }
                        break;
                    default:
                        System.out.println("Invalid expression");
                        return 0;
                }
            }
        }
        while (top[0] != -1)
            postfix[j++] = pop(s, top);
        return 1;
    }

    public static void main(String[] args) {
        int flag = 0;
        char[] infix = new char[15];
        char[] postfix = new char[15];
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the infix expression: ");
        String input = scanner.next();
        infix = input.toCharArray();

        flag = infixToPostfix(infix, postfix);
        if (flag == 1)
            System.out.println("\nPostfix expression is: " + new String(postfix));
        else
            System.out.println("\nError");
    }
}

