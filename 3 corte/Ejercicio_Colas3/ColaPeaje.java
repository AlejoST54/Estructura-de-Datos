public class ColaPeaje {
    private Vehiculo salida;  
    private Vehiculo entrada;  
    private int tamanio;

    public ColaPeaje() {
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

    public Vehiculo peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay vehiculos en el carril.");
            return null;
        }
        return salida;
    }

    public void enqueue(Vehiculo vehiculo) {
        if (isEmpty()) {
            salida  = vehiculo;
            entrada = vehiculo;
        } else {
            entrada.siguiente = vehiculo;
            entrada = vehiculo;
        }
        tamanio++;
    }

    public Vehiculo dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay vehiculos para cobrar.");
            return null;
        }
        Vehiculo dato = salida;
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
        Vehiculo actual = salida;
        while (actual != null) {
            System.out.print("Placa:" + actual.placa
                    + " Tipo:" + actual.tipoVehiculo
                    + " Tarifa:$" + String.format("%.2f", actual.tarifa)
                    + " Exento:" + (actual.esExento ? "Si" : "No"));
            if (actual.siguiente != null)
                System.out.print(" > ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    public void cerrarTurno() {
        if (isEmpty()) {
            System.out.println("No hay vehiculos en el carril.");
            return;
        }
        System.out.println("\n--- CIERRE DE TURNO ---");
        double totalRecaudado = 0.0;
        int cobrados = 0;
        int exentos  = 0;
        while (!isEmpty()) {
            Vehiculo v = dequeue();
            if (v.esExento) {
                exentos++;
                System.out.println("Placa: " + v.placa + " [" + v.tipoVehiculo + "] — EXENTO (no cobrado)");
            } else {
                totalRecaudado += v.tarifa;
                cobrados++;
                System.out.println("Placa: " + v.placa + " [" + v.tipoVehiculo
                        + "] — Cobrado: $" + String.format("%.2f", v.tarifa));
            }
        }
        System.out.println("--- FIN DEL TURNO ---");
        System.out.println("Vehiculos cobrados: " + cobrados);
        System.out.println("Vehiculos exentos:  " + exentos);
        System.out.printf("TOTAL RECAUDADO:    $%.2f%n", totalRecaudado);
    }
}
