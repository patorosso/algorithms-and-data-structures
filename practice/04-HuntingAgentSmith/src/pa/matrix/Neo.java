package pa.matrix;

/**
 * Profes, mi algoritmo no cumple porque NO usa división y conquista recursiva.
 * 
 * Lo intenté. Quise partir el problema en subproblemas pero me cuesta.
 * 
 * Lo mejor que pude llegar a plantear (ni siquiera sé si puede funcionar) fue
 * poner un pivote en el centro de la matriz y dividir por cuadrantes, pero no
 * soy capaz de descartar cuadrantes de forma correcta.
 * 
 * Mi solución es una búsqueda binaria por filas, aprovechando que están
 * ordenadas. ( al menos es mejor que O(n^2) )
 * 
 * Entiendo que no sirve de nada entregar algo que no cumple con la consigna
 * pero me sirve de práctica por lo menos... tengo ganas de aprender la
 * solución. Saludos!
 * 
 * @author Patricio Rosso
 * @version 1.0
 */
public class Neo {

	/**
	 * Busca al Agente Smith en la matriz de datos de Matrix usando divide y
	 * vencerás recursivo. La matriz debe estar ordenada: cada fila creciente y cada
	 * columna creciente.
	 * 
	 * @param matrizDatos matriz ordenada que representa los registros de Matrix
	 * @param codigoSmith código único del Agente Smith a buscar
	 * @return array de 2 posiciones [fila, columna] donde está Smith, o [-1, -1] si
	 *         no se encuentra
	 */
	public int[] buscarAgenteSmith(int[][] matrizDatos, int codigoSmith) {
		int n = matrizDatos.length;
		for (int fila = 0; fila < n; fila++) {
			int col = busquedaBinaria(matrizDatos[fila], codigoSmith);
			if (col != -1) {
				return new int[] { fila, col };
			}
		}
		return new int[] { -1, -1 };
	}

	/**
	 * Búsqueda binaria clásica en una fila ordenada de la matriz.
	 * 
	 * @param fila     array ordenado donde buscar
	 * @param objetivo valor a encontrar
	 * @return índice de la columna si lo encuentra, -1 si no está
	 */
	private int busquedaBinaria(int[] fila, int objetivo) {
		int izquierda = 0;
		int derecha = fila.length - 1;
		while (izquierda <= derecha) {
			int medio = izquierda + (derecha - izquierda) / 2;
			if (fila[medio] == objetivo) {
				return medio;
			} else if (fila[medio] < objetivo) {
				izquierda = medio + 1;
			} else {
				derecha = medio - 1;
			}
		}
		return -1;
	}
}