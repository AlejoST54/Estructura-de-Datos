import java.util.Scanner;

public class App {
//Carrusel de Imágenes (Galería Interactiva)
//Simula el comportamiento de una galería de fotos en una aplicación móvil.

//La Clase Fotografia (Nodo): Debe contener nombreArchivo (String), tamanoMB (double) y resolucion (String).
//El Problema: El usuario puede avanzar a la "Siguiente Foto" o retroceder a la "Foto Anterior". Si llega al final, no puede avanzar más (a menos que sea circular, pero por ahora manténlo lineal).
//Reto: Crea un método reproducirGaleria() que recorra toda la lista hacia adelante y luego toda la lista hacia atrás para mostrar todas las fotos.
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Fotografia historial = new Fotografia();
        Galeria cambioActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("   GALERIA INTERACTIVA — Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Fotos");
            System.out.println("  [2] ");
            System.out.println("  [3] Rehacer Cambio");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el texto del cambio: ");
                    sc.nextLine(); // Consumir el salto de línea
                    String texto = sc.nextLine();
                    System.out.print("Ingrese el tipo de operación (Escribir/Borrar): ");
                    String tipoOperacion = sc.nextLine();
                    Cambio nuevoCambio = new Cambio(texto, tipoOperacion);
                    historial.agregarCambio(nuevoCambio);
                    cambioActual = nuevoCambio; // Mover el puntero al nuevo cambio
                    break;

                case 2:
                    if (cambioActual != null) {
                        System.out.println("Cambio actual: " + cambioActual.texto);
                        cambioActual = historial.deshacer(cambioActual);
                        System.out.println("Cambio deshecho: " + cambioActual.texto);
                    } else {
                        System.out.println("No hay cambios para deshacer.");
                    }
                    break;

                case 3:
                    if (cambioActual != null) {
                        System.out.println("Cambio actual: " + cambioActual.texto);
                        cambioActual = historial.rehacer(cambioActual);
                        System.out.println("Cambio rehecho: " + cambioActual.texto);
                    } else {
                        System.out.println("No hay cambios para rehacer.");
                    }
                    break;

                case 0:
                    System.out.println("¡Saliendo del módulo de Listas Dobles!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    
    }
}
