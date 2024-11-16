package Stack;

public class ReversePolishNotation {
    private final CustomStack stack;

    public ReversePolishNotation() {
        stack = new CustomStack();
    }

    public int evaluate(String expression) {
        if (expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Wyrażenie nie może być puste");
        }

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(token);
            } else {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Brak operandów dla operatora: " + token);
                }
                int secondOperand = Integer.parseInt(stack.pop());

                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Brak operandów dla operatora: " + token);
                }
                int firstOperand = Integer.parseInt(stack.pop());

                switch (token) {
                    case "+":
                        stack.push(String.valueOf(firstOperand + secondOperand));
                        break;
                    case "-":
                        stack.push(String.valueOf(firstOperand - secondOperand));
                        break;
                    case "*":
                        stack.push(String.valueOf(firstOperand * secondOperand));
                        break;
                    default:
                        throw new IllegalArgumentException("Nieznany operator: " + token);
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String expression = "5 3 + 2 *"; // Przykładowe wyrażenie
        int result = rpn.evaluate(expression);
        System.out.println("Wynik: " + result);
    }
}