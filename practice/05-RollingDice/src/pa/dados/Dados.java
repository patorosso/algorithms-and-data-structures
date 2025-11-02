package pa.dados;

import java.util.*;

/**
 * Clase utilitaria para calcular combinaciones de resultados con dados de seis
 * caras (D6).
 * 
 * @author Rosso, Patricio
 * @version 1.0
 */
public class Dados {

	public static void main(String[] args) {
		System.out.println(Dados.calcularCombinaciones(3, 3));

	}

	/**
	 * Calcula de cuántas maneras distintas se puede obtener una suma objetivo
	 * lanzando una cantidad determinada de dados de seis caras (D6).
	 * 
	 * @param cantidadDados número de dados a lanzar
	 * @param sumaObjetivo  suma total que se desea alcanzar
	 * @return cantidad de combinaciones diferentes que suman exactamente el valor
	 *         objetivo, o 0 si la suma es imposible de alcanzar
	 */
	public static int calcularCombinaciones(int cantidadDados, int sumaObjetivo) {
//		return calcularCombinaciones(cantidadDados, sumaObjetivo, new HashMap<Integer, Integer>(),
//				new int[cantidadDados]);

		return calcularCombinaciones(cantidadDados, sumaObjetivo, new int[cantidadDados]);
	}

	private static int calcularCombinaciones(int cantidadDados, int sumaObjetivo, int[] dados) {

		boolean arrayEstaListoParaSumar = true;

		for (int i = 0; i < cantidadDados; i++) {
			if (dados[i] == 0) {
				arrayEstaListoParaSumar = false;
				break;
			}
		}

		if (arrayEstaListoParaSumar) {
			int sumaDados = 0;
			for (int i = 0; i < cantidadDados; i++)
				sumaDados += dados[i];

			return sumaDados == sumaObjetivo ? 1 : 0;
		}

		int[] arrayCara1 = completarArray(Arrays.copyOf(dados, cantidadDados), 1);
		int[] arrayCara2 = completarArray(Arrays.copyOf(dados, cantidadDados), 2);
		int[] arrayCara3 = completarArray(Arrays.copyOf(dados, cantidadDados), 3);
		int[] arrayCara4 = completarArray(Arrays.copyOf(dados, cantidadDados), 4);
		int[] arrayCara5 = completarArray(Arrays.copyOf(dados, cantidadDados), 5);
		int[] arrayCara6 = completarArray(Arrays.copyOf(dados, cantidadDados), 6);

		int cara1 = calcularCombinaciones(cantidadDados, sumaObjetivo, arrayCara1);
		int cara2 = calcularCombinaciones(cantidadDados, sumaObjetivo, arrayCara2);
		int cara3 = calcularCombinaciones(cantidadDados, sumaObjetivo, arrayCara3);
		int cara4 = calcularCombinaciones(cantidadDados, sumaObjetivo, arrayCara4);
		int cara5 = calcularCombinaciones(cantidadDados, sumaObjetivo, arrayCara5);
		int cara6 = calcularCombinaciones(cantidadDados, sumaObjetivo, arrayCara6);

		return cara1 + cara2 + cara3 + cara4 + cara5 + cara6;
	}

	private static int[] completarArray(int[] array, int proximoNumero) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				array[i] = proximoNumero;
				break;
			}
		}

		return array;
	}
}
