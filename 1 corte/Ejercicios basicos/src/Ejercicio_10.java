public class Ejercicio_10 {
//Ejercicio 10 — Copiando configuración
//Una app tiene un objeto int[] configuracion = {1920, 1080, 60} (resolución y FPS).
//Crea una copia real del arreglo (no una referencia) usando un nuevo arreglo y copiando elemento por elemento.
//Modifica la copia y demuestra que el original no cambia.
//Comenta la diferencia con la asignación directa.
    public static void main(String[] args) {
        int[] configuracion = {1920, 1080, 60}; 

        int[] copiaConfiguracion = new int[configuracion.length];
        for (int i = 0; i < configuracion.length; i++) {
            copiaConfiguracion[i] = configuracion[i];
        }

        System.out.println("Configuración original:");
        for (int i = 0; i < configuracion.length; i++) {
            System.out.println("Elemento " + i + ": " + configuracion[i]);
        }

        
        copiaConfiguracion[0] = 1280; 
        copiaConfiguracion[1] = 720; 
        copiaConfiguracion[2] = 30; 

        System.out.println("\nDespués de modificar la copia:");
        System.out.println("Configuración original:");
        for (int i = 0; i < configuracion.length; i++) {
            System.out.println("Elemento " + i + ": " + configuracion[i]);
        }

        System.out.println("\nCopia de configuración modificada:");
        for (int i = 0; i < copiaConfiguracion.length; i++) {
            System.out.println("Elemento " + i + ": " + copiaConfiguracion[i]);
        }
    }
}
