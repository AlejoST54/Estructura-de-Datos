import java.util.Scanner;
public class Ordenamiento_2 {
//Organización de Biblioteca Dinámica
//Algoritmo obligatorio: Ordenamiento por Inserción (Insertion Sort)

//Contexto: Un bibliotecario recibe una caja de libros y los va colocando uno a uno en el estante en su posición correcta.
//Detalle del ejercicio: El usuario debe ingresar la cantidad de libros y luego el código ISBN (número entero) de cada uno.
//Lógica de Inserción: A medida que el usuario ingresa un número, o una vez llenado el arreglo, el algoritmo debe simular el proceso de "insertar" el elemento comparándolo con los que ya están a su izquierda.
//Visualización Paso a Paso: En cada ciclo del ordenamiento, el programa debe imprimir cómo va quedando el arreglo (ej: [10, 25, 5, 30] -> [5, 10, 25, 30]). Esto permite al estudiante ver cómo los elementos se desplazan para abrir espacio al nuevo valor.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de libros: ");
        int cantidadLibros = sc.nextInt();
        int[] codigosLibros = new int[cantidadLibros];

        for (int i=0; i<cantidadLibros; i++){
            System.out.println("Ingrese el cdigo del libro " + (i+1) + ": ");
            codigosLibros[i] = sc.nextInt();
            System.out.println("Agregado Correctamente");
            for (int codigo : codigosLibros) {
                System.out.print("[" + codigo + "] ");
            }
            System.out.println();
        }
        
        for (int i = 1; i < codigosLibros.length; i++) {
            int clave = codigosLibros[i];
            int j = i - 1;

            while (j >= 0 && codigosLibros[j] > clave) {
                codigosLibros[j + 1] = codigosLibros[j];
                j--;
            }
            codigosLibros[j + 1] = clave;
            System.out.print("Estado del arreglo despus de insertar el libro " + (i + 1) + ": ");
            for (int k = 0; k < codigosLibros.length; k++) {
                System.out.print(codigosLibros[k] + " ");
            }
            System.out.println();
        }
    }
}
