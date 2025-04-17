package streetNumbers;

public class StreetNumbers {

	public static void main(String[] args) {

		int numberOfHouses = 9800;

		int result = constante(numberOfHouses);

		System.out.println(result);
	}

	static int cuadratica(int n) {

		// The solution has to be always more than the half,
		// because if you start by the middle then you would end up
		// with two sets identical in length but one side has all bigger numbers.

		int house = n / 2;
		int leftSum, rightSum;

		do {
			house++;
			leftSum = 0;
			rightSum = 0;

			// right sum:
			for (int j = house + 1; j <= n; j++)
				rightSum += j;

			// left sum:
			for (int j = 1; j <= house - 1; j++)
				leftSum += j;

		} while (leftSum < rightSum);

		return leftSum == rightSum ? house : -1;
	}

	static int lineal(int n) {

		int house = n / 2;
		int leftSum = 0, totalSum = 0;

		for (int i = 1; i <= n; i++)
			totalSum += i;

		do {
			house++;
			leftSum = 0;

			// left sum:
			for (int j = 1; j <= house - 1; j++)
				leftSum += j;

		} while (leftSum < totalSum - leftSum - house);

		return leftSum == totalSum - leftSum - house ? house : -1;

	}

	static int lineal2(int n) {
		if (n < 3)
			return -1;

		for (int i = 1; i <= n; i++) {
			int leftSum = (i - 1) * i / 2;
			int rightSum = (n * (n + 1) / 2 - i * (i + 1) / 2);
			if (leftSum == rightSum)
				return i;
		}
		return -1;
	}

	// Looking at the top one we can mathematically equal
	// both leftSum and rightSum to come up with a result value
	// that depends on the initial n numbers.
	static int constante(int n) {
		if (n < 3)
			return -1;
		
		double i = Math.sqrt((Math.pow(n,2)+n)/2);
		int wholePart = (int) i;
		return wholePart - i == 0 ? (int) i : -1;
	}
}
