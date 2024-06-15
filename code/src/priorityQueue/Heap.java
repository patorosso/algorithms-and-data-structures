package priorityQueue;

// an implementation of a MIN-Heap using an array of integers

public class Heap {

	private int size;
	private int[] heapArray;

	public Heap(int capacity) throws Exception {
		if (capacity <= 0)
			throw new Exception("Heap size must be > 0.");

		size = 0;
		heapArray = new int[capacity + 1];
	}

	// insert
	public boolean insert(int element) {

		if (size == heapArray.length - 1)
			return false;

		size++;
		heapArray[size] = element;

		// swap
		int currentPosition = size;
		int parentPosition = size / 2;
		while (parentPosition > 0 && heapArray[parentPosition] > element) {
			heapArray[currentPosition] = heapArray[parentPosition];
			heapArray[parentPosition] = element;

			int aux = parentPosition;
			parentPosition /= 2;
			currentPosition = aux;
		}

		return true;
	}

	// extract
	public int extract() {
		if (size == 0)
			return Integer.MAX_VALUE;

		// result
		int i = 1;
		int root = heapArray[i];

		// new root
		heapArray[i] = heapArray[size];
		size--;

		// swapping using min children
		while (i * 2 <= size) {
			int leftChild = heapArray[i * 2];
			int rightChild = i * 2 + 1 <= size ? heapArray[i * 2 + 1] : Integer.MAX_VALUE;
			int minChild = leftChild < rightChild ? leftChild : rightChild;

			if (minChild >= heapArray[i])
				break;

			int minPosition = minChild == leftChild ? i * 2 : i * 2 + 1;
			int aux = heapArray[i];
			heapArray[i] = minChild;
			heapArray[minPosition] = aux;

			i = minPosition;
		}

		return root;
	}

	// peek
	public int peek() {
		return size > 0 ? heapArray[1] : Integer.MAX_VALUE;
	}

	// print
	public void printHeap() {
		if (size == 0) {
			System.out.println("There are no elements.");
			return;
		}

		for (int i = 1; i <= size; i++) {
			System.out.print(heapArray[i] + " ");
		}
	}

}
