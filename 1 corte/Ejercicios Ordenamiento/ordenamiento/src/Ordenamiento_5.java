import java.util.Scanner;
public class Ordenamiento_5 {
//El Inspector de Eficiencia (Duelo de Métodos)
//Algoritmos obligatorios: Selección vs Inserción

//Contexto: Un analista de sistemas quiere saber cuál algoritmo es más "pesado" en términos de operaciones para un caso específico.
//Detalle del ejercicio: El usuario debe ingresar 6 números enteros desordenados. El programa aplicará AMBOS métodos al mismo conjunto de datos (puedes usar una copia del arreglo original).
//Lógica de Conteo:
//En Selección: Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
//En Inserción: Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno.
//Resultado esperado: El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientos hizo Inserción. El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[6];
        int[] copiaNumeros = new int[6];

        System.out.println("Ingrese 6 números enteros desordenados:");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
            copiaNumeros[i] = numeros[i];
        }
        int intercambiosSeleccion = 0;
        for (int i = 0; i < numeros.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] < numeros[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                int temp = numeros[indiceMinimo];
                numeros[indiceMinimo] = numeros[i];
                numeros[i] = temp;
                intercambiosSeleccion++;
            }
        }
        int movimientosInsercion = 0;
        for (int i = 1; i < copiaNumeros.length; i++) {
            int clave = copiaNumeros[i];
            int j = i - 1;

            while (j >= 0 && copiaNumeros[j] > clave) {
                copiaNumeros[j + 1] = copiaNumeros[j];
                j--;
                movimientosInsercion++;
            }
            copiaNumeros[j + 1] = clave;
        }
        System.out.println("Numero de intercambios en Seleccion: " + intercambiosSeleccion);
        System.out.println("Numero de movimientos en Insercin: " + movimientosInsercion);
        if (intercambiosSeleccion < movimientosInsercion) {
            System.out.println("El método de Selección fue mas eficiente para estos datos.");
        } else if (movimientosInsercion < intercambiosSeleccion) {
            System.out.println("El metodo de Insercion fue mas eficiente para estos datos.");
        } else {
            System.out.println("Ambos metodos tuvieron la misma eficiencia para estos datos.");
        }
        
    }
}
