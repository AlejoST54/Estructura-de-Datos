public class Ensamblaje {
    private Pieza tope;
    private int tamanio;

    public Ensamblaje() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Pieza nueva) {
        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    public Pieza pop() {
        if (!estaVacia()) {
            Pieza piezaRetirada = tope;
            tope = tope.siguiente;
            tamanio--;
            return piezaRetirada;
        } else {
            System.out.println("La línea de ensamblaje está vacía. No hay piezas para retirar.");
            return null;
        }
    }

    public void imprimir() {
        if (!estaVacia()) {
            Pieza actual = tope;
            while (actual != null) {
                System.out.println(actual);
                actual = actual.siguiente;
            }
        } else {
            System.out.println("La línea de ensamblaje está vacía.");
        }
    }

    public void limpiarHastaDefecto() {
        while (!estaVacia()) {
            Pieza piezaActual = tope;
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