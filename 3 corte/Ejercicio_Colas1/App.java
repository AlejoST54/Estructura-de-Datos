import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaUrgencias cola = new ColaUrgencias();
        Scanner scanner = new Scanner(System.in);


        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE URGENCIAS HOSPITALARIAS (COLAS) ---");
            System.out.println("1. Ver pacientes en espera");
            System.out.println("2. Registrar nuevo paciente (Enqueue)");
            System.out.println("3. Atender siguiente paciente (Dequeue)");
            System.out.println("4. Ver proximo paciente sin atender (Peek)");
            System.out.println("5. Atender todos los pacientes (atenderTodos)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la cola:");
                    cola.imprimir();
                    System.out.println("Total en espera: " + cola.size());
                    break;

                case 2:
                    System.out.print("Cedula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Sintoma principal: ");
                    String sintoma = scanner.nextLine();
                    cola.enqueue(new Paciente(cedula, nombre, edad, sintoma));
                    System.out.println("Paciente registrado correctamente.");
                    break;

                case 3:
                    Paciente atendido = cola.dequeue();
                    if (atendido != null) {
                        System.out.println("\nPaciente atendido:");
                        System.out.println("Cedula: " + atendido.cedula
                                + " | Nombre: " + atendido.nombreCompleto
                                + " | Edad: " + atendido.edad
                                + " | Sintoma: " + atendido.sintomaPrincipal);
                    }
                    break;

                case 4:
                    Paciente proximo = cola.peek();
                    if (proximo != null) {
                        System.out.println("\nProximo paciente a ser atendido:");
                        System.out.println("Cedula: " + proximo.cedula
                                + " | Nombre: " + proximo.nombreCompleto
                                + " | Edad: " + proximo.edad
                                + " | Sintoma: " + proximo.sintomaPrincipal);
                    }
                    break;

                case 5:
                    cola.atenderTodos();
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
