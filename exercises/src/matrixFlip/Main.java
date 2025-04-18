package matrixFlip;

public class Main {

	public static void main(String[] args) {

//		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix = {
			    {  5,  1,  9, 11 },
			    {  2,  4,  8, 10 },
			    { 13,  3,  6,  7 },
			    { 15, 14, 12, 16 }
			};

		flip90firstApproach(matrix);
		System.out.println("First approach: \n");
		printMatrix(matrix);

//		flip90secondApproach(matrix);
//		System.out.println("\nSecond approach: \n");
//		printMatrix(matrix);

	}

	private static void flip90firstApproach(int[][] matrix) {

		int aux;
		int n = matrix.length;

		// Comments are for my own, used at debugging the 3x3 example, but works
		// for other N's as well.

		for (int j = 0; j < matrix.length / 2; j++) {

			for (int i = 0; i < matrix.length - 1 - (j * 2); i++) {

				aux = matrix[j][j + i]; // Save the 1
				matrix[j][j + i] = matrix[n - i - 1 - j][j]; // Place the 7 on the 1
				matrix[n - i - 1 - j][j] = matrix[n - j - 1][n - 1 - i - j]; // 9 on the 7
				matrix[n - j - 1][n - 1 - i - j] = matrix[i + j][n - j - 1]; // 3 on the 9
				matrix[i + j][n - j - 1] = aux;
			}
		}
	}

	private static void flip90secondApproach(int[][] matrix) {

		int aux;
		int n = matrix.length;

		// Swap over the opposite diagonal (we just go by the first triangle and swap)
		for (int i = 0; i < n - 1; i++) {

			for (int j = n - 1; j > 0 + i; j--) {
				aux = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = aux;
			}
		}

		// Swap vertically till the half, so we don't end up with the same matrix again
		for (int i = 0; i < n / 2; i++) {
			
			for (int j = 0; j < n; j++) {
				aux = matrix[j][i];
				matrix[j][i] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = aux;
			}
		}
	}

	private static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print((matrix[i][j] > 9 ? matrix[i][j] : "0" + matrix[i][j]) + " ");

			System.out.println();

		}

	}

}
