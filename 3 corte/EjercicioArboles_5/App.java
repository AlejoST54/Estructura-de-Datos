import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolInventario arbol = new ArbolInventario();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- CONTROL DE INVENTARIO - ALMACÉN DE REPUESTOS (BST) ---");
            System.out.println("1. Ver inventario ordenado por código (InOrden)");
            System.out.println("2. Backup en PreOrden (para reconstruir el árbol)");
            System.out.println("3. Insertar nuevo repuesto");
            System.out.println("4. Buscar repuesto por código");
            System.out.println("5. Reporte de repuestos únicos (sin variantes)");
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
                    arbol.backupPreOrden();
                    break;

                case 3:
                    System.out.print("Código de referencia: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Stock (unidades): ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    arbol.insertar(codigo, descripcion, marca, stock);
                    System.out.println("Repuesto insertado correctamente.");
                    break;

                case 4:
                    System.out.print("Código a buscar: ");
                    int busqueda = scanner.nextInt();
                    scanner.nextLine();
                    Repuesto encontrado = arbol.buscar(busqueda);
                    if (encontrado != null)
                        System.out.println("Repuesto encontrado: " + encontrado);
                    else
                        System.out.println("No se encontró ningún repuesto con código " + busqueda + ".");
                    break;

                case 5:
                    System.out.println();
                    arbol.reporteRepuestosUnicos();
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
