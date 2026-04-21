import java.util.Scanner;

public class App {
//Carrusel de Anuncios (Pantalla Digital)
//Una tienda tiene una pantalla que muestra anuncios en rotación continua. Cuando termina el último anuncio, vuelve automáticamente al primero.

//La Clase Anuncio (Nodo): Debe contener titulo (String), duracionSegundos (int), vecesRepetido (int) y categoria (String - ej: "Oferta", "Marca", "Evento").
//El Problema: La pantalla necesita saber cuánto tiempo total lleva encendida y cuál es el anuncio que más veces se ha repetido.
//Reto: Implementa el método reproducir(int ciclos) que simule ciclos pasadas completas por todos los anuncios, incrementando 
//vecesRepetido en cada paso e imprimiendo qué anuncio está en pantalla. 
//Al finalizar, muestra el anuncio más repetido y el tiempo total acumulado en pantalla.
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Carrusel Sorteo = new Carrusel();

        do {
            System.out.println("\n==============================================");
            System.out.println("   Anuncios — Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. agregarAnuncio");
            System.out.println("2. mostrarAnuncios");
            System.out.println("3. reproducir");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {
                case 1:
                        System.out.print("Ingrese el titulo del anuncio ");
                        String titulo = sc.next();
                        System.out.print("Ingrese la duracion del Anuncio ");
                        int duracion = sc.nextInt();
                        System.out.print("Ingrese la categoria del Anuncio: ");
                        String categoria = sc.next();
                        Anuncio nuevoAnuncio = new Anuncio(titulo, duracion, categoria);
                        Sorteo.agregarAnuncio(nuevoAnuncio);                    
                    break;
                case 2:
                    System.out.println("Anuncios:");
                    Sorteo.mostrarAnuncios();
                    break;

                case 3:
                    System.out.print("Reproducir Anuncios");
                    int ciclos = sc.nextInt();
                    Sorteo.reproducir(ciclos);
                    break;
                
                case 0:
                    System.out.println("¡Saliendo del Menu");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    
    }
}
