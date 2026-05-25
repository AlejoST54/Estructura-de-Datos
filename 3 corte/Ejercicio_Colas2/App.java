import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ColaImpresora cola = new ColaImpresora();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE COLA DE IMPRESION (COLAS) ---");
            System.out.println("1. Ver documentos en cola");
            System.out.println("2. Enviar nuevo documento (Enqueue)");
            System.out.println("3. Imprimir siguiente documento (Dequeue)");
            System.out.println("4. Ver proximo documento sin imprimir (Peek)");
            System.out.println("5. Calcular paginas totales en espera (calcularPaginasTotales)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la cola:");
                    cola.imprimir();
                    System.out.println("Total documentos en espera: " + cola.size());
                    break;

                case 2:
                    System.out.print("Nombre del archivo: ");
                    String archivo = scanner.nextLine();
                    System.out.print("Usuario: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Numero de paginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Es color? (true/false): ");
                    boolean esColor = scanner.nextBoolean();
                    scanner.nextLine();
                    cola.enqueue(new Documento(archivo, usuario, paginas, esColor));
                    System.out.println("Documento enviado a la cola correctamente.");
                    break;

                case 3:
                    Documento impreso = cola.dequeue();
                    if (impreso != null) {
                        System.out.println("\nImprimiendo documento:");
                        System.out.println("Archivo: " + impreso.nombreArchivo
                                + " | Usuario: " + impreso.usuario
                                + " | Paginas: " + impreso.numeroPaginas
                                + " | Color: " + (impreso.esColor ? "Si" : "No"));
                    }
                    break;

                case 4:
                    Documento proximo = cola.peek();
                    if (proximo != null) {
                        System.out.println("\nProximo documento a imprimir:");
                        System.out.println("Archivo: " + proximo.nombreArchivo
                                + " | Usuario: " + proximo.usuario
                                + " | Paginas: " + proximo.numeroPaginas
                                + " | Color: " + (proximo.esColor ? "Si" : "No"));
                    }
                    break;

                case 5:
                    int totalPaginas = cola.calcularPaginasTotales();
                    System.out.println("Total de paginas pendientes en cola: " + totalPaginas);
                    System.out.println("Documentos en cola (sin cambios): " + cola.size());
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
