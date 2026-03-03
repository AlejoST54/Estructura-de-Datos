public class Ejercicio_5Array {
//5. Contador de Estudiantes (Registro Académico)
//Un profesor tiene un arreglo con las notas finales de 30 estudiantes (ej: 3.5, 4.0, 2.8, 5.0, ...).

//El Problema: El profesor necesita saber exactamente cuántos estudiantes sacaron una nota de 5.0.
//Algoritmo a usar: Búsqueda Lineal con Contador. Debes recorrer todo el arreglo y, cada vez que encuentres un 5.0, aumentar una variable contador.
    public static void main(String[] args) {
        double[] notasFinales = {3.5, 4.0, 2.8, 5.0, 4.5, 4.0, 3.0};
        int contador=0;
        for (int i = 0; i < notasFinales.length; i++) {
            if (notasFinales[i] == 5.0) {
                contador++;
            }
        }
        System.out.println("Número de estudiantes con nota 5.0: " + contador);
    }

}
