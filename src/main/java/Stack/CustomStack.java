package Stack;

import java.util.ArrayList;

public class CustomStack {
    private final ArrayList<String> elements;

    public CustomStack() {
        elements = new ArrayList<>();
    }

    public void push(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Nie można dodać wartości null do stosu.");
        }
        elements.add(item);
    }

    public String pop() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stos jest pusty.");
        }
        return elements.remove(elements.size() - 1);
    }

    public String peek() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stos jest pusty.");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}