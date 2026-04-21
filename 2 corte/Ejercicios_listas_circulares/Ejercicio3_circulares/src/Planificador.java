public class Planificador {
    Proceso cabeza;
    Proceso cola;
    public void agregarProceso(Proceso proceso) {
        if (cabeza == null) {
            cabeza = proceso;
            cola = proceso;
            proceso.siguiente = cabeza; 
        } else {
            cola.siguiente = proceso; 
            proceso.siguiente = cabeza; 
            cola = proceso; 
        }
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos para ejecutar.");
            return;
        }

        Proceso actual = cabeza;

        while (cabeza != null) {
            System.out.println("Ejecutando proceso: " + actual.nombre + " (PID: " + actual.pid + ")");
            actual.tiempoRestante -= quantum;

            if (actual.tiempoRestante <= 0) {
                System.out.println("Proceso " + actual.nombre + " ha terminado.");
                Proceso siguiente = actual.siguiente;
                eliminarProceso(actual);
                actual = siguiente;
            } else {
                System.out.println("Tiempo restante de " + actual.nombre + ": " + actual.tiempoRestante);
                actual = actual.siguiente;
            }
        }
        System.out.println("Todos los procesos han terminado.");
    }


    private void eliminarProceso(Proceso proceso) {
        if (cabeza == null) return;

        if (proceso == cabeza && proceso == cola) {
            cabeza = null;
            cola = null;
        } else if (proceso == cabeza) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        } else {
            Proceso actual = cabeza;
            while (actual.siguiente != proceso) {
                actual = actual.siguiente;
            }
            actual.siguiente = proceso.siguiente;
            if (proceso == cola) {
                cola = actual;
            }
        }
    }

}
