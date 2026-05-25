import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPeaje cola = new ColaPeaje();
        Scanner scanner = new Scanner(System.in);


        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE PEAJE INTELIGENTE (COLAS) ---");
            System.out.println("1. Ver vehiculos en carril");
            System.out.println("2. Registrar nuevo vehiculo (Enqueue)");
            System.out.println("3. Cobrar siguiente vehiculo (Dequeue)");
            System.out.println("4. Ver proximo vehiculo sin cobrar (Peek)");
            System.out.println("5. Cerrar turno y calcular total recaudado (cerrarTurno)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual del carril:");
                    cola.imprimir();
                    System.out.println("Total vehiculos en carril: " + cola.size());
                    break;

                case 2:
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Tipo de vehiculo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Tarifa: ");
                    double tarifa = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Es exento? (true/false): ");
                    boolean exento = scanner.nextBoolean();
                    scanner.nextLine();
                    cola.enqueue(new Vehiculo(placa, tipo, tarifa, exento));
                    System.out.println("Vehiculo registrado correctamente.");
                    break;

                case 3:
                    Vehiculo cobrado = cola.dequeue();
                    if (cobrado != null) {
                        System.out.println("\nVehiculo procesado:");
                        System.out.println("Placa: " + cobrado.placa
                                + " | Tipo: " + cobrado.tipoVehiculo
                                + " | Tarifa: $" + String.format("%.2f", cobrado.tarifa)
                                + " | Exento: " + (cobrado.esExento ? "Si" : "No"));
                    }
                    break;

                case 4:
                    Vehiculo proximo = cola.peek();
                    if (proximo != null) {
                        System.out.println("\nProximo vehiculo a cobrar:");
                        System.out.println("Placa: " + proximo.placa
                                + " | Tipo: " + proximo.tipoVehiculo
                                + " | Tarifa: $" + String.format("%.2f", proximo.tarifa)
                                + " | Exento: " + (proximo.esExento ? "Si" : "No"));
                    }
                    break;

                case 5:
                    cola.cerrarTurno();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
