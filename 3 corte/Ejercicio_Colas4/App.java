import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaPedidos cola = new ColaPedidos();
        Scanner scanner = new Scanner(System.in);


        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE PEDIDOS E-COMMERCE (COLAS) ---");
            System.out.println("1. Ver pedidos en cola");
            System.out.println("2. Registrar nuevo pedido (Enqueue)");
            System.out.println("3. Procesar siguiente pedido (Dequeue)");
            System.out.println("4. Ver proximo pedido sin procesar (Peek)");
            System.out.println("5. Procesar todos los pedidos (procesarPedidos)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la cola:");
                    cola.imprimir();
                    System.out.println("Total pedidos en espera: " + cola.size());
                    break;

                case 2:
                    System.out.print("Numero de pedido: ");
                    String numero = scanner.nextLine();
                    System.out.print("Nombre del cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Total a pagar: ");
                    double total = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Esta cancelado? (true/false): ");
                    boolean cancelado = scanner.nextBoolean();
                    scanner.nextLine();
                    cola.enqueue(new Pedido(numero, cliente, total, cancelado));
                    System.out.println("Pedido registrado correctamente.");
                    break;

                case 3:
                    Pedido procesado = cola.dequeue();
                    if (procesado != null) {
                        System.out.println("\nPedido extraido de la cola:");
                        System.out.println("Pedido #" + procesado.numeroPedido
                                + " | Cliente: " + procesado.cliente
                                + " | Total: $" + String.format("%.2f", procesado.totalPagar)
                                + " | Estado: " + (procesado.cancelado ? "CANCELADO" : "Vigente"));
                    }
                    break;

                case 4:
                    Pedido proximo = cola.peek();
                    if (proximo != null) {
                        System.out.println("\nProximo pedido a procesar:");
                        System.out.println("Pedido #" + proximo.numeroPedido
                                + " | Cliente: " + proximo.cliente
                                + " | Total: $" + String.format("%.2f", proximo.totalPagar)
                                + " | Estado: " + (proximo.cancelado ? "CANCELADO" : "Vigente"));
                    }
                    break;

                case 5:
                    cola.procesarPedidos();
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
