package sorting;

import java.util.Arrays;

public class Sort {

	public static int[] timSort(int[] array) {

		if (array.length <= 1)
			return array;

		int minimumRunSize = 4; // generally a power of 2
		int[] newArray = Arrays.copyOf(array, array.length);

		for (int i = 0; i < minimumRunSize; i++) {

		}

		return array;
	}

	public static int[] insertion(int[] array) {

		if (array.length <= 1)
			return array;

		int[] newArray = Arrays.copyOf(array, array.length);

		for (int i = 1; i < newArray.length; i++) {
			for (int j = i; j > 0; j--) {
				if (newArray[j] < newArray[j - 1]) {
					int aux = newArray[j];
					newArray[j] = newArray[j - 1];
					newArray[j - 1] = aux;
				} else
					break;
			}
		}

		return newArray;
	}

	public static int[] selection(int[] array) {

		if (array.length <= 1)
			return array;

		int[] newArray = Arrays.copyOf(array, array.length);

		for (int i = 1; i < array.length; i++) {
			int posMin = i - 1;
			for (int j = i; j < array.length; j++) {
				if (newArray[j] < newArray[posMin]) {
					posMin = j;
				}
			}
			int aux = newArray[i - 1];
			newArray[i - 1] = newArray[posMin];
			newArray[posMin] = aux;
		}

		return newArray;
	}

}
