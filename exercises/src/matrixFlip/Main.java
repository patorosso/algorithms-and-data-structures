package matrixFlip;

public class Main {

	public static void main(String[] args) {

		
		//int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix = {
			    {  5,  1,  9, 11 },
			    {  2,  4,  8, 10 },
			    { 13,  3,  6,  7 },
			    { 15, 14, 12, 16 }
			};
		
		
		flip90firstApproach(matrix);
		printMatrix(matrix);

	}

	private static void flip90firstApproach(int[][] matrix) {

		int aux1, currentN;

		for (int j = 0; j < matrix.length / 2; j++) {

			currentN = matrix.length - (j * 2); // Para legibilidad

			for (int i = 0; i < matrix.length - 1; i++) {

				aux1 = matrix[j][j + i]; // Guardo el 1
				matrix[j][j + i] = matrix[currentN - i - 1][j]; // Pongo el 7 en el 1
				matrix[currentN - i - 1][j] = matrix[currentN - j - 1][currentN - 1 - i]; // 9 en el 7
				matrix[currentN - j - 1][currentN - 1 - i] = matrix[i][currentN - j - 1]; // 3 en el 9
				matrix[i][currentN - j - 1] = aux1;
			}
		}
	}

	private static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();

		}

	}

}
