import java.util.Scanner;
public class Ordenamiento_1 {
//El Podio de la Competencia
//Algoritmo obligatorio: Ordenamiento por Selección (Selection Sort)

//Contexto: Se ha realizado una carrera de 100 metros planos y el comité olímpico necesita determinar quiénes ganaron las medallas.
//Detalle del ejercicio: El programa debe solicitar primero cuántos corredores participaron (ej. 5 a 10). Luego, debe pedir el tiempo en segundos (con decimales) de cada corredor.
//lógica de Selección: El algoritmo debe buscar el tiempo más bajo (el más rápido) en cada iteración y colocarlo al inicio.
//Resultado esperado: El programa debe imprimir el arreglo totalmente ordenado y, adicionalmente, mostrar un mensaje claro indicando quién obtuvo el Oro (1er lugar), Plata (2do lugar) y Bronce (3er lugar)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de corredores (entre 5 y 10): ");
        int numCorredores = sc.nextInt();

        while (numCorredores < 5 || numCorredores > 10) {
            System.out.println("Número inválido. Por favor, ingrese un número entre 5 y 10: ");
            numCorredores = sc.nextInt();
        }

        double[] tiempos = new double[numCorredores];

        for (int i = 0; i < numCorredores; i++) {
            System.out.println("Ingrese el tiempo del corredor " + (i + 1) + " en segundos: ");
            tiempos[i] = sc.nextDouble();
        }

        for (int i = 0; i < tiempos.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < tiempos.length; j++) {
                if (tiempos[j] < tiempos[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            double temp = tiempos[indiceMinimo];
            tiempos[indiceMinimo] = tiempos[i];
            tiempos[i] = temp;
        }

        // Imprimir resultados
        System.out.println("Resultados ordenados:");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Corredor " + (i + 1) + ": " + tiempos[i] + " segundos");
        }

        if (tiempos.length >= 3) {
            System.out.println("Medallas:");
            System.out.println("Oro: Corredor con tiempo " + tiempos[0] + " segundos");
            System.out.println("Plata: Corredor con tiempo " + tiempos[1] + " segundos");
            System.out.println("Bronce: Corredor con tiempo " + tiempos[2] + " segundos");
        } else {
            System.out.println("No hay suficientes corredores para asignar medallas.");
        }
    }

}
