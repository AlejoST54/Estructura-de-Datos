import java.util.Scanner;

public class App {
    // Logística de Distribución (Callejón sin Salida)
    // Un centro de logística urbana tiene un muelle de carga ubicado al final de un callejón muy estrecho.
    // Los camiones de reparto entran uno tras otro y quedan "atrapados" en el orden de llegada. 
    // El último camión en entrar debe ser obligatoriamente el primero en salir para permitir que los demás se retiren.

    // La Clase Camion (Nodo): Debe contener placa (String), conductor (String) y cargaToneladas (double).
    // El Problema: El supervisor necesita saber cuánta carga total hay en el callejón sin mover los camiones físicamente (solo consultando la estructura).
    // Reto: Implementa un método que recorra la pila (sin destruirla permanentemente, o reconstruyéndola) y calcule la suma total de cargaToneladas de todos los camiones estacionados.
    public static void main(String[] args) throws Exception {
            System.out.println("Hello, World!");
            Logistica logistica = new Logistica();
            Scanner scanner = new Scanner(System.in);

            int opcion;
            do {
                System.out.println("\n--- LOGICA DE DISTRIBUCION (CALLEJÓN SIN SALIDA) ---");
                System.out.println("1. Ver camiones en el callejón");
                System.out.println("2. Registrar nuevo camión (Push)");
                System.out.println("3. Retirar camión del tope (Pop)");
                System.out.println("4. Calcular carga total en el callejón");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\nEstado actual de la pila:");
                        logistica.imprimir();
                        break;
                    case 2:
                        System.out.print("Placa: "); String placa = scanner.nextLine();
                        System.out.print("Conductor: "); String conductor = scanner.nextLine();
                        System.out.print("Carga (toneladas): "); double carga = scanner.nextDouble();
                        scanner.nextLine();
                        logistica.agregarCamion(new Camion(placa, conductor, carga));
                        System.out.println("Camión agregado correctamente.");
                        break;
                    case 3:
                        Camion retirado = logistica.retirarCamion();
                        if (retirado != null) {
                            System.out.println("Se ha retirado: " + retirado);
                        } else {
                            System.out.println("El callejón está vacío.");
                        }
                        break;
                    case 4:
                        System.out.println("Carga total en el callejón: " + logistica.calcularCargaTotal() + " toneladas");
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
