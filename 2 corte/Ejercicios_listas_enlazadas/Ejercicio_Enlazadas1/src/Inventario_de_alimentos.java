import java.util.Scanner;

public class Inventario_de_alimentos extends Producto {

    public Inventario_de_alimentos(String nombre, int cantidad, int dia_para_vencer) {
        super(nombre, cantidad, dia_para_vencer);
    }

    public static Producto verificaProducto(Producto nuevo, Producto cabeza) {
        if (cabeza == null || nuevo.getDiaParaVencer() < 3) {
            nuevo.setSiguiente(cabeza);
            return nuevo;
        } else {
            Producto actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            return cabeza;
        }
    }

    public static void imprimirInventario(Producto cabeza) {
        Producto actual = cabeza;
        int posicion = 1;
        while (actual != null) {
            String alerta = actual.getDiaParaVencer() < 3 ? " PROXIMO A VENCER" : "";
            System.out.println(posicion + ". " + actual.getNombre()
                    + " | Cantidad: " + actual.getCantidad()
                    + " | Dias para vencer: " + actual.getDiaParaVencer()
                    + alerta);
            actual = actual.getSiguiente();
            posicion++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cuantos productos desea registrar? ");
        int cantidad = Integer.parseInt(sc.nextLine().trim());

        Producto cabeza = null;

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\n--- Producto #" + i + " ---");

            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine().trim();

            System.out.print("Cantidad: ");
            int cantidadProducto = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Dias para vencer: ");
            int diasParaVencer = Integer.parseInt(sc.nextLine().trim());

            Inventario_de_alimentos nuevo = new Inventario_de_alimentos(nombre, cantidadProducto, diasParaVencer);

            if (diasParaVencer < 3) {
                System.out.println("Producto proximo a vencer. Movido al inicio del inventario.");
            }

            cabeza = verificaProducto(nuevo, cabeza);
        }

        System.out.println("\n=== Inventario completo (ordenado por prioridad) ===");
        imprimirInventario(cabeza);

        System.out.println("\n=== Productos proximos a vencer (menos de 5 dias) ===");
        Producto actual = cabeza;
        boolean hayUrgentes = false;
        while (actual != null) {
            if (actual.getDiaParaVencer() < 5) {
                System.out.println("- " + actual.getNombre()
                        + " | Cantidad: " + actual.getCantidad()
                        + " | Dias para vencer: " + actual.getDiaParaVencer());
                hayUrgentes = true;
            }
            actual = actual.getSiguiente();
        }
        if (!hayUrgentes) {
            System.out.println("No hay productos proximos a vencer.");
        }

        sc.close();
    }
}