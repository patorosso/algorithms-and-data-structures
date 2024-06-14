package divideAndConquer;

public class Power {

	public static double doIt(double number, int exponent) {

		if (exponent == 0)
			return 1;

		if (exponent == 1)
			return number;

		double result;

		if (exponent % 2 == 0)
			result = doIt(number, exponent / 2) * doIt(number, exponent / 2);
		else
			result = doIt(number, exponent / 2) * doIt(number, exponent / 2) * number;

		return result;

	}

}
