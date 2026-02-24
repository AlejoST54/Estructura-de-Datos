import java.util.Scanner;
public class Ejercicio_2Input {
//Ejercicio 2 — Conversor de temperatura
//Pide al usuario una temperatura en Celsius y conviértela a Fahrenheit y Kelvin.

//Fórmulas:

//F = (C × 9/5) + 32
//K = C + 273.15
//Dato de entrada: double temperatura en Celsius
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la temperatura en Celsius: ");
        double temperatura = sc.nextDouble();
        double F = (temperatura * 9/5) + 32;
        double k = temperatura + 273.15;


    }

}
