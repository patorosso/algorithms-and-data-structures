package main;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try {
			int[] numbers = { -1, 13, -43, 43, -5, -44 };
			sort(numbers, SortType.INSERTION);

			System.out.println(Arrays.toString(numbers));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public enum SortType {
		BUBBLE, SELECTION, INSERTION
	}

	private static void sort(int[] array, SortType type) {
		if (array == null || array.length < 2)
			return;

		switch (type) {
		case BUBBLE:
			bubble(array);
			return;
		case SELECTION:
			selection(array);
			return;
		case INSERTION:
			insertion(array);
			return;
		default:
			throw new IllegalArgumentException("Sort type not defined. Found: " + type);
		}
	}

	private static void insertion(int[] array) {
		int n = array.length;

		for (int i = 1; i < n; i++) { // n - 1 -> O(n)
			int aux = array[i]; // O(1)
			int iOrdenado = i - 1; // O(1)

			while (iOrdenado >= 0 && aux < array[iOrdenado]) { // en el peor de los casos es n
				array[iOrdenado + 1] = array[iOrdenado]; // O(1)
				iOrdenado--; // O(1)
			}

			array[iOrdenado + 1] = aux; // O(1)
		}
	}

	private static void selection(int[] array) {
		int n = array.length;

		// n(n-1)/2 ≈ O(n²)
		for (int i = 0; i < n - 1; i++) { // O(n)
			int minPos = i; // O(1)
			for (int j = i + 1; j < n; j++) { // O(...) tambien termina siendo n pero como lo escribo?
				if (array[j] < array[minPos]) // O(1)
					minPos = j; // O(1)
			}
			if (minPos != i) { // O(1)
				int aux = array[minPos]; // O(1)
				array[minPos] = array[i]; // O(1)
				array[i] = aux; // O(1)
			}
		}
	}

	private static void bubble(int[] array) {
		int n = array.length;

		// (n-1) + (n-2) + (n-3) + ... + 1 (en total n-1 veces)
		// n(n-1)/2 ≈ O(n²)
		for (int i = 0; i < n - 1; i++) { // n - 1 veces -> O(n)

			for (int j = 0; j < n - 1 - i; j++) { // n - 1 - i -> en el peor caso i es chica -> O(n)

				if (array[j] > array[j + 1]) { // comparación -> O(1)

					int aux = array[j]; // asignación + desreferencia -> O(1)
					array[j] = array[j + 1]; // asignación + desreferencias + operación suma -> O(1)
					array[j + 1] = aux; // asignación + operación suma + desreferencia O(1)

				}
			}
		}
	}
}
