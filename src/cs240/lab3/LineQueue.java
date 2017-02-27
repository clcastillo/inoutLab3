package cs240.lab3;

import java.util.Vector;

public class LineQueue<T> implements QueueInterface<T> {
	private Vector<T> queue;

	public LineQueue() {
		queue = new Vector<T>();
	}

	public LineQueue(int initialCapacity) {
		queue = new Vector<T>(initialCapacity);
	}

	public void enqueue(T newEntry) {
		queue.add(newEntry);
	}

	public T getFront() {
		T front = null;
		if (!isEmpty())
			front = queue.get(0);
		return front;
	}

	public T dequeue() {
		T front = null;
		if (!isEmpty())
			front = queue.remove(0);
		return front;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	} // end isEmpty

	public void clear() {
		queue.clear();
	}

}
