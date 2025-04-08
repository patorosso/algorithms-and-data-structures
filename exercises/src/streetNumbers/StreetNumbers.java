package streetNumbers;

public class StreetNumbers {

	public static void main(String[] args) {

		int numberOfHouses = 8;

		int result = cuadratica(numberOfHouses);

		System.out.println(result);
	}

	static int cuadratica(int n) {

		// The solution has to be always more than the half,
		// because if you start by the middle then you would end up
		// with two sets identical in length but one side has all bigger numbers.

		int leftSum, rightSum;
		int house = n / 2;

		do {
			leftSum = 0;
			rightSum = 0;
			house++;

			// right sum:
			for (int j = house + 1; j <= n; j++)
				rightSum += j;

			// left sum:
			for (int j = 0; j <= house - 1; j++)
				leftSum += j;

		} while (leftSum < rightSum);

		return leftSum == rightSum ? house : -1;
	}

	static int lineal(int n) {
		return -1;
	}

	static int constante(int n) {
		return -1;
	}
}
