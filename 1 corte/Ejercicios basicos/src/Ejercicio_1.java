public class Ejercicio_1 {

//Ejercicio 1 — Ficha de un estudiante
//Un sistema universitario necesita registrar la información básica de un estudiante: 
//nombre completo, código (número entero), semestre actual, promedio acumulado y si está matriculado o no.
//Declara las variables con los tipos de datos apropiados.
//Asigna valores de ejemplo
    public static void main(String[] args) {
        String nombre = "Jose Alejandro Sanchez Tellez";
        int codigo = 12345;
        String carrera = "Ingenieria en Sistemas";
        float promedio = 4.5f;
        boolean matriculado = true;

        System.out.println("**********Datos del estudiante*************" );

        System.out.println("Nombre: " + nombre);
        System.out.println("Codigo: " + codigo);
        System.out.println("Carrera: " + carrera);
        System.out.println("Promedio: " + promedio);
        System.out.println("Matriculado: " + matriculado);
    }
}
