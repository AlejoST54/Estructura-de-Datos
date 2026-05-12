import java.util.Scanner;

public class App {
//Farmacia Automatizada (Dispensador Tubo LIFO)
//En una farmacia de alta tecnología, los medicamentos de alta rotación se almacenan en tubos dispensadores verticales. 
//El personal introduce las cajas por la parte superior y las retira de la misma forma (el último lote en llegar es el primero en ser despachado).

//La Clase Medicamento (Nodo): Debe contener nombre (String), lote (String) y diasParaVencer (int).
//El Problema: Por norma de seguridad, no se puede despachar un medicamento si le quedan menos de 10 días para vencer.
//Reto: Implementa un método validarDespacho() que revise el medicamento en el tope. Si está a punto de vencer, 
//debe ser retirado automáticamente y el sistema debe revisar el siguiente. El proceso se repite hasta que el tope sea un medicamento seguro o la pila quede vacía.
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Farmacia logistica = new Farmacia();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- FARMACIA AUTOMATIZADA (DISPENSADOR TUBO LIFO) ---");
            System.out.println("1. Ver medicamentos en el dispensador");
            System.out.println("2. Registrar nuevo medicamento (Push)");
            System.out.println("3. Retirar medicamento del tope (Pop)");
            System.out.println("4. Calcular carga total en el dispensador");
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
                    System.out.print("Nombre: "); String nombre = scanner.nextLine();
                    System.out.print("Lote: "); String lote = scanner.nextLine();
                    System.out.print("Días para vencer: "); int diasParaVencer = scanner.nextInt();
                    scanner.nextLine();
                    logistica.agregarMedicamento(new Medicamento(nombre, lote, diasParaVencer));
                    System.out.println("Medicamento agregado correctamente.");
                    break;
                case 3:
                    Medicamento retirado = logistica.retirarMedicamento();
                    if (retirado != null) {
                        System.out.println("Se ha retirado: " + retirado);
                    } else {
                        System.out.println("El callejón está vacío.");
                    }
                    break;
                case 4:
                    logistica.validarDespacho();
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
