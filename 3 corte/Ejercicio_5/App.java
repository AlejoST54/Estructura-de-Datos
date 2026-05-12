import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Ruta ruta = new Ruta();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- RUTA DE RESCATE (ESPELEOLOGÍA GEOLÓGICA) ---");
            System.out.println("1. Ver estaciones registradas");
            System.out.println("2. Registrar nueva estación (Push)");
            System.out.println("3. Retirar estación del tope (Pop)");
            System.out.println("4. Retroceder a superficie");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstaciones en la ruta:");
                    ruta.imprimir();
                    break;
                case 2:
                    System.out.print("Nombre del punto: ");
                    String nombrePunto = scanner.nextLine();
                    System.out.print("Profundidad (m): ");
                    int profundidad = scanner.nextInt();
                    System.out.print("Nivel de oxígeno (%): ");
                    double nivelOxigeno = scanner.nextDouble();
                    scanner.nextLine();
                    ruta.agregarEstacion(new Estacion(nombrePunto, profundidad, nivelOxigeno));
                    System.out.println("Estación registrada correctamente.");
                    break;
                case 3:
                    Estacion retirada = ruta.retirarEstacion();
                    if (retirada != null) {
                        System.out.println("Se ha retirado: " + retirada);
                    }
                    break;
                case 4:
                    ruta.retrocederASuperficie();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}
