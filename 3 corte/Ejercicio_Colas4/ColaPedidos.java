public class ColaPedidos {
    private Pedido salida; 
    private Pedido entrada; 
    private int tamanio;

    public ColaPedidos() {
        salida   = null;
        entrada  = null;
        tamanio  = 0;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public int size() {
        return tamanio;
    }

    public Pedido peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay pedidos pendientes.");
            return null;
        }
        return salida;
    }

    public void enqueue(Pedido pedido) {
        if (isEmpty()) {
            salida  = pedido;
            entrada = pedido;
        } else {
            entrada.siguiente = pedido;
            entrada = pedido;
        }
        tamanio++;
    }

    public Pedido dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay pedidos para procesar.");
            return null;
        }
        Pedido dato = salida;
        salida = salida.siguiente;
        if (salida == null) {
            entrada = null;
        }
        tamanio--;
        return dato;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida > ");
        Pedido actual = salida;
        while (actual != null) {
            System.out.print("Pedido:#" + actual.numeroPedido
                    + " Cliente:" + actual.cliente
                    + " Total:$" + String.format("%.2f", actual.totalPagar)
                    + " Estado:" + (actual.cancelado ? "CANCELADO" : "Vigente"));
            if (actual.siguiente != null)
                System.out.print(" > ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    public void procesarPedidos() {
        if (isEmpty()) {
            System.out.println("No hay pedidos en la cola.");
            return;
        }
        System.out.println("\n--- PROCESAMIENTO DE PEDIDOS ---");
        int totalDespachados = 0;
        int totalCancelados  = 0;
        while (!isEmpty()) {
            Pedido p = dequeue();
            if (p.cancelado) {
                totalCancelados++;
                System.out.println("DESCARTADO — Pedido #" + p.numeroPedido
                        + " | Cliente: " + p.cliente
                        + " | Motivo: cancelado por el cliente");
            } else {
                totalDespachados++;
                System.out.println("DESPACHADO — Pedido #" + p.numeroPedido
                        + " | Cliente: " + p.cliente
                        + " | Total: $" + String.format("%.2f", p.totalPagar));
            }
        }
        System.out.println("--- FIN DEL PROCESAMIENTO ---");
        System.out.println("Total despachados: " + totalDespachados);
        System.out.println("Total cancelados:  " + totalCancelados);
        System.out.println("Total procesados:  " + (totalDespachados + totalCancelados));
    }
}
