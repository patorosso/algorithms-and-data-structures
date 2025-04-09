package streetNumbers;

public class StreetNumbers {

	public static void main(String[] args) {

		int numberOfHouses = 9800;

		int result = lineal(numberOfHouses);

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
		
		int house = n/2;
		int leftSum = 0, totalSum = 0;
		
		for(int i = 1; i <= n; i++)
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

	static int constante(int n) {
		return -1;
	}
}
