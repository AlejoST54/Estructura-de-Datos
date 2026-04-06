import java.util.Scanner;

public class App {
//Spotify Lite (Lista de Reproducción)
//Crea un reproductor de música simplificado que gestione una lista de canciones.

//La Clase Cancion (Nodo): Debe contener titulo (String), artista (String), duracionSegundos (int) y genero (String).
//El Problema: El usuario puede agregar canciones "A continuación" (insertar después de la actual) o "Al final de la cola".
//Reto: Implementa un método que sume la duración de todas las canciones y muestre el tiempo total de la lista en formato MM:SS.
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        cancion tren = new cancion();

        do {
            System.out.println("\n==============================================");
            System.out.println("   SPOTIFY LITE - Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. Agregar canción a continuacion");
            System.out.println("2. Agregar canción al final");
            System.out.println("3. Mostrar la lista de canciones");
            System.out.println("4. Mostrar duración total");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el titulo de la canción: ");
                    sc.nextLine();
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese el artista de la canción: ");
                    String artista = sc.nextLine();
                    System.out.print("Ingrese la duración de la canción (en segundos): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el género de la canción: ");
                    String genero = sc.nextLine();

                    cancion nuevaCancion = new cancion(titulo, artista, duracion, genero);
                    Fila_Reproduccion.agregarCancion(tren, nuevaCancion);
                    break;
                case 2:
                    System.out.print("Ingrese el titulo de la cancion: ");
                    sc.nextLine();
                    String titulo2 = sc.nextLine();
                    System.out.print("Ingrese el artista de la canción: ");
                    String artista2 = sc.nextLine();
                    System.out.print("Ingrese la duración de la canción (en segundos): ");
                    int duracion2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el género de la canción: ");
                    String genero2 = sc.nextLine();

                    cancion nuevaCancion2 = new cancion(titulo2, artista2, duracion2, genero2);
                    Fila_Reproduccion.agregarCancionAlFinal(tren, nuevaCancion2);
                    break;
                case 3:
                    System.out.println("Lista de canciones:");
                    Fila_Reproduccion.imprimirLista(tren);
                    break;
                case 4:
                    int duracionTotal = Fila_Reproduccion.duracionTotal(tren);
                    int minutos = duracionTotal / 60;
                    int segundos = duracionTotal % 60;
                    System.out.println("La duración total de la lista es: " + minutos + ":" + (segundos < 10 ? "0" : "") + segundos);
                    break;
                case 0:
                    System.out.println("¡Saliendo de Spotify Lite!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
