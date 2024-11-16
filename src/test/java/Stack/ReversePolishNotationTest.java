package Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationTest {

    @Test
    public void testEvaluateSimpleExpression() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(14, rpn.evaluate("3 4 + 2 *"));
    }

    @Test
    public void testEvaluateComplexExpression() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(3, rpn.evaluate("8 4 - 4 * 3"));
    }

    @Test
    public void testSingleNumber() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(7, rpn.evaluate("7"));
    }

    @Test
    public void testInvalidOperator() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertThrows(IllegalArgumentException.class, () -> rpn.evaluate("3 4 &"));
    }

    @Test
    public void testEmptyExpression() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertThrows(IllegalArgumentException.class, () -> rpn.evaluate(""));
    }

    @Test
    public void testInsufficientOperands() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertThrows(IllegalArgumentException.class, () -> rpn.evaluate("3 +"));
    }

    @Test
    public void testNoOperandsForOperator() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertThrows(IllegalArgumentException.class, () -> rpn.evaluate("+"));
    }

    @Test
    public void testNegativeNumbers() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(-7, rpn.evaluate("-3 -4 +"));
    }

    @Test
    public void testMultiplicationByZero() {
        ReversePolishNotation rpn = new ReversePolishNotation();
        assertEquals(0, rpn.evaluate("3 0 *"));
    }
}