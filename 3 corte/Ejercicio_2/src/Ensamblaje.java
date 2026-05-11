public class Ensamblaje {
    private Pieza[] pila;
    private int tope;
    private int capacidad;

    public Ensamblaje() {
        this.capacidad = 100; // Capacidad máxima de la pila
        this.pila = new Pieza[capacidad];
        this.tope = -1; // Indica que la pila está vacía
    }

    public void push(Pieza pieza) {
        if (tope < capacidad - 1) {
            tope++;
            pila[tope] = pieza;
        } else {
            System.out.println("La línea de ensamblaje está llena. No se pueden agregar más piezas.");
        }
    }

    public Pieza pop() {
        if (tope >= 0) {
            Pieza piezaRetirada = pila[tope];
            pila[tope] = null; // Limpia la referencia para evitar fugas de memoria
            tope--;
            return piezaRetirada;
        } else {
            System.out.println("La línea de ensamblaje está vacía. No hay piezas para retirar.");
            return null;
        }
    }

    public void imprimir() {
        if (tope >= 0) {
            for (int i = tope; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        } else {
            System.out.println("La línea de ensamblaje está vacía.");
        }
    }

    public void limpiarHastaDefecto() {
        while (tope >= 0) {
            Pieza piezaActual = pila[tope];
            if (piezaActual.isEsDefectuosa()) {
                System.out.println("Pieza defectuosa encontrada: " + piezaActual.getNombrePieza());
                break;
            } else {
                System.out.println("Pieza buena retirada: " + piezaActual.getNombrePieza());
                pop();
            }
        }
    }
}