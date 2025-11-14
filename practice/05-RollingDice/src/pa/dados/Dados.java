package pa.dados;

import java.util.*;

/**
 * Clase utilitaria para calcular combinaciones de resultados con dados de seis
 * caras (D6).
 * 
 * @author Rosso, Patricio
 * @version 2.0
 * 
 */
public class Dados {

	public static final int DADOS_MINIMOS = 1;
	public static final int OBJETIVO_MINIMO = 3;

	public static void main(String[] args) {
		System.out.println("Resultado final: " + Dados.calcularCombinaciones(3, 3));
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
		if (cantidadDados < DADOS_MINIMOS || sumaObjetivo < OBJETIVO_MINIMO)
			return 0;

		return calcularCombinaciones(cantidadDados, sumaObjetivo, new HashMap<String, Integer>());
	}

	private static int calcularCombinaciones(int cantidadDados, int sumaObjetivo, HashMap<String, Integer> mapa) {
		if (cantidadDados < 0 || sumaObjetivo < 0)
			return 0;

		String clave = cantidadDados + "-" + sumaObjetivo;
		if (mapa.containsKey(clave)) {
			System.out.println("Encontró clave: " + clave);
			return mapa.get(clave);
		}

		boolean obtuvoObjetivo = cantidadDados == 0 && sumaObjetivo == 0;
		if (obtuvoObjetivo) {
			System.out.println("Puso clave: " + clave);
			mapa.put(clave, 1);
			return 1;
		}

		var cara1 = calcularCombinaciones(cantidadDados - 1, sumaObjetivo - 1, mapa);
		var cara2 = calcularCombinaciones(cantidadDados - 1, sumaObjetivo - 2, mapa);
		var cara3 = calcularCombinaciones(cantidadDados - 1, sumaObjetivo - 3, mapa);
		var cara4 = calcularCombinaciones(cantidadDados - 1, sumaObjetivo - 4, mapa);
		var cara5 = calcularCombinaciones(cantidadDados - 1, sumaObjetivo - 5, mapa);
		var cara6 = calcularCombinaciones(cantidadDados - 1, sumaObjetivo - 6, mapa);

		int total = cara1 + cara2 + cara3 + cara4 + cara5 + cara6;
		System.out.println("Puso clave: " + clave);
		mapa.put(clave, total);

		return total;
	}
}
