import java.util.Scanner;

//a-b*(c+d/e)*f
public class shuntingYard {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an infix notation: ");
        String infix = scanner.nextLine();
        scanner.close();

        char[] infixArray = infix.toCharArray();
        char[] postfixArray = new char[infixArray.length];
        char[] stackArray = new char[infixArray.length];
        int postfixIndex = 0;
        int stackIndex = 0;

        for (char element : infixArray) {
            if (Character.isLetter(element)) {
                postfixArray[postfixIndex++] = element;
            } else if (element == '(') {
                stackArray[stackIndex++] = element;
            } else if (element == ')') {
                while (stackIndex > 0 && stackArray[stackIndex - 1] != '(') {
                    postfixArray[postfixIndex++] = stackArray[--stackIndex];
                }
                if (stackIndex > 0 && stackArray[stackIndex - 1] == '(') {
                    stackIndex--;
                }
            } else { 
                int operatorPrecedence = (element == '*' || element == '/') ? 2 : 1;

                while (stackIndex > 0) {
                    char topOperator = stackArray[stackIndex - 1];
                    if (topOperator == '(' || operatorPrecedence > (topOperator == '*' || topOperator == '/' ? 2 : 1)) {
                        break;
                    }
                    postfixArray[postfixIndex++] = stackArray[--stackIndex];
                }
                stackArray[stackIndex++] = element;
            }
        }
        while (stackIndex > 0) {
            postfixArray[postfixIndex++] = stackArray[--stackIndex];
        }
        String postfixNotation = new String(postfixArray, 0, postfixIndex);
        System.out.println("Postfix Notation:\n" + postfixNotation);
    }
}
