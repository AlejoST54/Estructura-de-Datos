import java.util.Scanner;
public class Ordenamiento_3 {
//El Salto de Shell (Optimización de Datos)
//Algoritmo obligatorio: Ordenamiento Shell (Shell Sort)

//Contexto: Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos de forma más eficiente que el método de burbuja o inserción simple.
//Detalle del ejercicio: Solicita al usuario el peso de N paquetes (se recomienda probar con al menos 10 para notar el efecto).
//Lógica de Shell: Implementa el algoritmo usando el salto (gap) inicial de 
//N/2
//El estudiante debe explicar en comentarios por qué este método es generalmente más rápido que la inserción simple al trabajar con elementos que están muy lejos de su posición final.
//Resultado esperado: Mostrar el arreglo original y el arreglo final ordenado después de aplicar todas las fases de reducción de saltos.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de paquetes: ");
        int cantidadPaquetes = sc.nextInt();
        double[] pesosPaquetes = new double[cantidadPaquetes];

        for (int i=0; i<cantidadPaquetes; i++){
            System.out.println("Ingrese el peso del paquete " + (i+1) + ": ");
            pesosPaquetes[i] = sc.nextDouble();
        }

        System.out.println("Arreglo original:");
        for (double peso : pesosPaquetes) {
            System.out.print(peso + " ");
        }
        System.out.println();

        for (int gap = cantidadPaquetes / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < cantidadPaquetes; i++) {
                double temp = pesosPaquetes[i];
                int j;
                for (j = i; j >= gap && pesosPaquetes[j - gap] > temp; j -= gap) {
                    pesosPaquetes[j] = pesosPaquetes[j - gap];
                }
                pesosPaquetes[j] = temp;
            }
        }

        System.out.println("Arreglo ordenado:");
        for (double peso : pesosPaquetes) {
            System.out.print(peso + " ");
        }
    }
}
