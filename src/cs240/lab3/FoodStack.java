package cs240.lab3;

import java.util.Vector;

public class FoodStack<T> {
	private Vector<T> stack;
	private static final int DEFAULTINICAP = 10;

	public FoodStack() {
		this(DEFAULTINICAP);
	}

	public FoodStack(int initialCapacity) {
		stack = new Vector<T>(initialCapacity);
	}

	public void push(T newEntry) {
		stack.add(newEntry);
	}

	public T pop() {
		T top = null;
		if (!isEmpty())
			top = stack.remove(stack.size() - 1);
		return top;
	}

	public T peek() {
		T top = null;
		if (!isEmpty())
			top = stack.lastElement();
		return top;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public void clear() {
		stack.clear();

	}
}
