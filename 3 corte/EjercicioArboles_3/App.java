import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolNomina arbol = new ArbolNomina();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE NÓMINA - RECURSOS HUMANOS (BST) ---");
            System.out.println("1. Ver empleados ordenados por cédula (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo empleado");
            System.out.println("4. Buscar empleado por cédula");
            System.out.println("5. Empleado con cédula mínima (más antiguo)");
            System.out.println("6. Empleado con cédula máxima (más reciente)");
            System.out.println("7. Reporte de eficiencia del árbol");
            System.out.println("8. Salir");
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
                    System.out.print("Cédula: ");
                    long cedula = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    arbol.insertar(cedula, nombre, cargo, salario);
                    System.out.println("Empleado insertado correctamente.");
                    break;

                case 4:
                    System.out.print("Cédula a buscar: ");
                    long busqueda = scanner.nextLong();
                    scanner.nextLine();
                    Empleado encontrado = arbol.buscar(busqueda);
                    if (encontrado != null)
                        System.out.println("Empleado encontrado: " + encontrado);
                    else
                        System.out.println("No se encontró ningún empleado con cédula " + busqueda + ".");
                    break;

                case 5:
                    System.out.println();
                    arbol.buscarMinimo();
                    break;

                case 6:
                    System.out.println();
                    arbol.buscarMaximo();
                    break;

                case 7:
                    System.out.println();
                    arbol.reporteEficiencia();
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
