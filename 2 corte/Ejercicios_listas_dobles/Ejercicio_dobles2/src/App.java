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
        Galeria cambioActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("   GALERIA INTERACTIVA — Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Fotos");
            System.out.println("  [2] Siguiente Foto");
            System.out.println("  [3] Foto Anterior");
            System.out.println("  [4] Reproducir Galería");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("¡Agregando fotos a la galería!");
                    System.out.println("cual es el nombre del archivo de la foto?");
                    String nombreArchivo = sc.next();
                    System.out.println("cual es el tamaño en MB de la foto?");
                    double tamanoMB = sc.nextDouble();
                    System.out.println("cual es la resolución de la foto?");
                    String resolucion = sc.next();
                    Fotografia nuevaFoto = new Fotografia(nombreArchivo, tamanoMB, resolucion);
                    System.out.println("Foto agregada: " + nuevaFoto.nombreArchivo + ", Tamaño: " + nuevaFoto.tamanoMB + "MB, Resolución: " + nuevaFoto.resolucion);
                    if (cambioActual == null) {
                        cambioActual = new Galeria();
                    }
                    cambioActual.agregarFoto(nuevaFoto);
                    break;
                case 2:
                    if (cambioActual != null) {
                        cambioActual.siguienteFoto();
                    } else {
                        System.out.println("No hay fotos en la galería para avanzar.");
                    }
                    break; 
                case 3:
                    if (cambioActual != null) {
                        cambioActual.fotoAnterior();
                    } else {
                        System.out.println("No hay fotos en la galería para retroceder.");
                    }
                    break;
                case 4:
                    if (cambioActual != null) {
                        cambioActual.reproducirGaleria();
                    } else {
                        System.out.println("No hay fotos en la galería para reproducir.");
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
