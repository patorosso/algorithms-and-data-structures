package priorityQueue;

public class Main {

	public static void main(String[] args) {

		try {

			int capacity = 15;
			Heap heap = new Heap(capacity);
			
			heap.insert(14);
			heap.insert(15);
			heap.insert(5);
			heap.insert(7);
			heap.insert(20);
			heap.insert(18);
			heap.insert(9);
			heap.insert(6);
			heap.insert(3);
			heap.insert(6);
			heap.insert(6);
			heap.insert(1);
			
			heap.printHeap();
			
			
			heap.extract();
			System.out.println("\n ----- Extracting 	------");
			
			System.out.println(" ----- After extraction ------");
			
			heap.printHeap();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
