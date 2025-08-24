package main;

public class Main {

	public static void main(String[] args) {
		try {
			int n = 8;
			int result = streetNumbers(n);

			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static int streetNumbers(int n) {
		if (n <= 2)
			throw new IllegalArgumentException("La entrada debe ser mayor a 2.");

//		return streetNumbersQuadratic(n);
//		return streetNumbersLinear(n);
		return streetNumbersConstant(n);
	}

	private static int streetNumbersQuadratic(int n) {

		for (int i = 2; i < n - 1; i++) {
			long leftSum = 0;
			for (int j = i - 1; j >= 1; j--)
				leftSum += j;

			long rightSum = 0;
			for (int j = i + 1; j <= n; j++)
				rightSum += j;

			if (leftSum == rightSum)
				return i;
		}

		return -1;
	}

	private static int streetNumbersLinear(int n) {
		long totalSum = (long) n * (n + 1) / 2;

		for (int i = 1; i <= n; i++) {
			long left = (long) i * (i - 1) / 2;
			if (2 * left + i == totalSum)
				return i;
		}
		return -1;
	}

	// Same es before but without the calculation
	private static int streetNumbersLegibleLinear(int n) {

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

	private static int streetNumbersConstant(int n) {
		long total = (long) n * (n + 1) / 2;
		long sqrt = (long) Math.sqrt(total);
		if (sqrt * sqrt == total) {
			return (int) sqrt;
		}
		return -1;
	}

}
