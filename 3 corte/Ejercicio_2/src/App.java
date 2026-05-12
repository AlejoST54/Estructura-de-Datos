import java.util.Scanner;

public class App {
//Control de Calidad (Línea de Ensamblaje)
//Un brazo robótico en una fábrica de motores apila componentes siguiendo una secuencia precisa. Un sensor de visión artificial inspecciona cada pieza después de ser colocada.

//La Clase Pieza (Nodo): Debe contener nombrePieza (String), numeroSerie (String) y esDefectuosa (boolean).
//El Problema: Si el sensor detecta una pieza defectuosa, la línea de producción debe detenerse inmediatamente.
//Reto: Crea un método limpiarHastaDefecto() que extraiga (pop) todas las piezas de la pila hasta encontrar la primera que tenga esDefectuosa = true.
//El método debe imprimir el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y descartadas antes de llegar a la pieza fallida.
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Ensamblaje piezaEnsamblaje = new Ensamblaje();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE CONTROL DE CALIDAD (PILAS) ---");
            System.out.println("1. Ver piezas en la línea de ensamblaje");
            System.out.println("2. Registrar nueva pieza (Push)");
            System.out.println("3. Retirar pieza del tope (Pop)");
            System.out.println("4. Limpiar hasta encontrar pieza defectuosa");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la pila:");
                    piezaEnsamblaje.imprimir();
                    break;
                case 2:
                    System.out.print("ID: "); String id = scanner.nextLine();
                    System.out.print("Empresa: "); String emp = scanner.nextLine();
                    piezaEnsamblaje.push(new Pieza(id, emp, false)); // Suponiendo que se crea una pieza normal
                    System.out.println("Pieza apilada correctamente.");
                    break;
                case 3:
                    Pieza retirada = piezaEnsamblaje.pop();
                    if (retirada != null) {
                        System.out.println("Se ha retirado: " + retirada);
                    } else {
                        System.out.println("La línea de ensamblaje está vacía.");
                    }
                    break;
                case 4:
                    piezaEnsamblaje.limpiarHastaDefecto();
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