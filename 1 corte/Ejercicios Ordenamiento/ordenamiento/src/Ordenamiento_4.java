import java.util.Scanner;
public class Ordenamiento_4 {
//Registro Alfabético de Estudiantes
//Algoritmo obligatorio: Ordenamiento por Inserción (Insertion Sort)

//Contexto: El profesor necesita pasar asistencia y requiere que la lista de nombres ingresada en el sistema se ordene alfabéticamente de la A a la Z.
//Detalle del ejercicio: El programa debe preguntar cuántos alumnos hay en clase y solicitar sus nombres (cadenas de texto).
//Lógica de Texto: Se debe usar el método de Inserción adaptado para String.
//Requisito técnico: El estudiante debe investigar y aplicar el método nombre1.compareToIgnoreCase(nombre2). Es vital explicar que si el resultado es mayor a 0, el primer nombre es alfabéticamente "mayor" que el segundo.
//Resultado esperado: La lista de asistencia impresa en orden alfabético perfecto.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = sc.nextInt();
        sc.nextLine();
        String[] nombresAlumnos = new String[cantidadAlumnos];

        for (int i=0; i<cantidadAlumnos; i++){
            System.out.println("Ingrese el nombre del alumno " + (i+1) + ": ");
            nombresAlumnos[i] = sc.nextLine();
        }
        
        for (int i = 1; i < nombresAlumnos.length; i++) {
            String clave = nombresAlumnos[i];
            int j = i - 1;

            while (j >= 0 && nombresAlumnos[j].compareToIgnoreCase(clave) > 0) {
                nombresAlumnos[j + 1] = nombresAlumnos[j];
                j--;
            }
            nombresAlumnos[j + 1] = clave;
        }

        System.out.println("Lista de asistencia ordenada alfabeticamente:");
        for (String nombre : nombresAlumnos) {
            System.out.println(nombre);
        }
    }
}
