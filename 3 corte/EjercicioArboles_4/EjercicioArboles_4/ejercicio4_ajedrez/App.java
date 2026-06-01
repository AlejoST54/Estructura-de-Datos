import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolTorneo arbol = new ArbolTorneo();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- TORNEO DE AJEDREZ - RANKING ELO (BST) ---");
            System.out.println("1. Ver todos los jugadores ordenados por ELO (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Inscribir nuevo jugador");
            System.out.println("4. Buscar jugador por ELO");
            System.out.println("5. Listar clasificados en rango de ELO");
            System.out.println("6. Propiedades del árbol (altura y hojas)");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println();
                    arbol.inOrden();
                    break;

                case 2:
                    System.out.println();
                    arbol.preOrden();
                    break;

                case 3:
                    System.out.print("ELO: ");
                    int elo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre de usuario: ");
                    String usuario = scanner.nextLine();
                    System.out.print("País: ");
                    String pais = scanner.nextLine();
                    System.out.print("Partidas jugadas: ");
                    int partidas = scanner.nextInt();
                    scanner.nextLine();
                    arbol.insertar(elo, usuario, pais, partidas);
                    System.out.println("Jugador inscrito correctamente.");
                    break;

                case 4:
                    System.out.print("ELO a buscar: ");
                    int busqueda = scanner.nextInt();
                    scanner.nextLine();
                    Jugador encontrado = arbol.buscar(busqueda);
                    if (encontrado != null)
                        System.out.println("Jugador encontrado: " + encontrado);
                    else
                        System.out.println("No se encontró ningún jugador con ELO " + busqueda + ".");
                    break;

                case 5:
                    System.out.print("ELO mínimo: ");
                    int eloMin = scanner.nextInt();
                    System.out.print("ELO máximo: ");
                    int eloMax = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    arbol.listarEnRango(eloMin, eloMax);
                    break;

                case 6:
                    System.out.println("Altura del árbol:  " + arbol.altura());
                    System.out.println("Nodos hoja:        " + arbol.contarHojas());
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
