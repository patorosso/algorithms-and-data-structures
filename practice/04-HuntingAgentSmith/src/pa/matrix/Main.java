package pa.matrix;

public class Main {

	public static void main(String[] args) {
        Neo neo = new Neo();

        int[][] matriz = {
            { 1,  4,  7, 11 },
            { 2,  5,  8, 12 },
            { 3,  6,  9, 16 },
            {10, 13, 14, 17 }
        };

        // Pruebas
        int[] res1 = neo.buscarAgenteSmith(matriz, 13); // debería dar [3,1]
        int[] res2 = neo.buscarAgenteSmith(matriz, 9);  // debería dar [2,2]
        int[] res3 = neo.buscarAgenteSmith(matriz, 20); // debería dar [-1,-1]

        imprimirResultado(13, res1);
        imprimirResultado(9, res2);
        imprimirResultado(20, res3);
    }

    private static void imprimirResultado(int objetivo, int[] resultado) {
        System.out.println("Buscando " + objetivo + " → (" + resultado[0] + "," + resultado[1] + ")");
    }

}
