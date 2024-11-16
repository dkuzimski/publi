package Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CustomStackTest {

    @Test
    public void testPushAndPeek() {
        CustomStack stack = new CustomStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        assertEquals("D", stack.peek());
    }

    @Test
    public void testPop() {
        CustomStack stack = new CustomStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.pop();
        assertEquals("C", stack.pop());
    }

    @Test
    public void testEmpty() {
        CustomStack stack = new CustomStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeekOnEmptyStack() {
        CustomStack stack = new CustomStack();
        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    public void testPopOnEmptyStack() {
        CustomStack stack = new CustomStack();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void testPushNull() {
        CustomStack stack = new CustomStack();
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }
}