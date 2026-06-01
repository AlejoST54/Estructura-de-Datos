import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolBiblioteca arbol = new ArbolBiblioteca();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- CATÁLOGO DIGITAL BIBLIOTECA UNIVERSITARIA (BST) ---");
            System.out.println("1. Imprimir catálogo ordenado por ISBN (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo libro");
            System.out.println("4. Buscar libro por ISBN");
            System.out.println("5. Verificar si un ISBN ya existe");
            System.out.println("6. Propiedades del árbol (altura y hojas)");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println();
                    arbol.imprimirCatalogo();
                    break;

                case 2:
                    System.out.println();
                    arbol.preOrden();
                    break;

                case 3:
                    System.out.print("ISBN (número largo): ");
                    long isbn = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    arbol.insertar(isbn, titulo, autor, anio);
                    System.out.println("Libro insertado correctamente.");
                    break;

                case 4:
                    System.out.print("ISBN a buscar: ");
                    long busqueda = scanner.nextLong();
                    scanner.nextLine();
                    Libro encontrado = arbol.buscar(busqueda);
                    if (encontrado != null)
                        System.out.println("Libro encontrado: " + encontrado);
                    else
                        System.out.println("No se encontró ningún libro con ISBN " + busqueda + ".");
                    break;

                case 5:
                    System.out.print("ISBN a verificar: ");
                    long verificar = scanner.nextLong();
                    scanner.nextLine();
                    if (arbol.existeISBN(verificar))
                        System.out.println("El ISBN " + verificar + " YA está registrado en el catálogo.");
                    else
                        System.out.println("El ISBN " + verificar + " NO existe. Puede registrar la donación.");
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
