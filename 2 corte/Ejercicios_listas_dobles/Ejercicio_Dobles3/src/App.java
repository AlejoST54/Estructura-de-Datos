import java.util.Scanner;

public class App {
//Navegación de Pestañas de Navegador
//Imagina un navegador donde puedes moverte entre pestañas abiertas.

//La Clase Pestana (Nodo): Debe contener tituloPagina (String), url (String) y horaApertura (String).
//El Problema: Las pestañas se abren una tras otra. A veces el usuario quiere cerrar la pestaña actual 
//y el foco debe pasar a la pestaña anterior.
//Reto: Implementar el método cerrarPestanaActual(String url) que busque la pestaña por URL, la elimine de la lista
//y reconecte el nodo anterior con el siguiente correctamente (¡Cuidado con la Cabeza y la Cola!).
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Navegador navegador = new Navegador();

        do {
            System.out.println("\n==============================================");
            System.out.println("   NAVEGACION DE PESTAÑAS — Menú Principal");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar pestañas");
            System.out.println("  [2] Cerrar pestaña actual");
            System.out.println("  [3] Mostrar pestañas abiertas");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("¡Agregando pestañas al navegador!");
                    System.out.println("cual es el titulo de la pagina?");
                    String tituloPagina = sc.next();
                    System.out.println("cual es la url de la pagina?");
                    String url = sc.next();
                    System.out.println("cual es la hora de apertura de la pagina?");
                    String horaApertura = sc.next();
                    Pestana nuevaPestana = new Pestana(tituloPagina, url, horaApertura);
                    System.out.println("Pestaña agregada: " + nuevaPestana.tituloPagina + ", URL: " + nuevaPestana.url + ", Hora de Apertura: " + nuevaPestana.horaApertura);
                    if (navegador.cabeza == null) {
                        navegador.cabeza = nuevaPestana;
                        navegador.cola = nuevaPestana;
                    } else {
                        navegador.cola.siguiente = nuevaPestana;
                        nuevaPestana.anterior = navegador.cola;
                        navegador.cola = nuevaPestana;
                    }
                    break;
                case 2:
                    System.out.println("cual es la url de la pestaña que deseas cerrar?");
                    String urlACerrar = sc.next();
                    navegador.cerrarPestanaActual(urlACerrar);
                    break;
                case 3:
                    System.out.println("Pestañas abiertas:");
                    navegador.mostrarPestanas();
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
