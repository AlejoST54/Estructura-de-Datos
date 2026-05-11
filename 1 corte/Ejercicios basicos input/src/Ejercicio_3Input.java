import java.util.Scanner;
public class Ejercicio_3Input {
//Ejercicio 3 — Promedio de notas
//Pide al usuario su nombre y 4 notas de un curso. Calcula el promedio y determina si aprobó (promedio >= 3.0).

//Datos de entrada:

//String nombre
//double nota1, nota2, nota3, nota4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la primera nota: ");
        double nota1 = sc.nextDouble();
        System.out.println("Ingrese la segunda nota: ");
        double nota2 = sc.nextDouble();
        System.out.println("Ingrese la tercera nota: ");
        double nota3 = sc.nextDouble();
        System.out.println("Ingrese la cuarta nota: ");
        double nota4 = sc.nextDouble();

        double promedio = (nota1 + nota2 + nota3 + nota4) / 4;

        if (promedio >= 3.0) {
            System.out.println(nombre + ", has aprobado con un promedio de " + promedio);
        } else {
            System.out.println(nombre + ", has reprobado con un promedio de " + promedio);
        }
        
    }

}
