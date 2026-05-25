public class ColaImpresora {
    private Documento salida;  
    private Documento entrada; 
    private int tamanio;

    public ColaImpresora() {
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

    public Documento peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay documentos pendientes.");
            return null;
        }
        return salida;
    }

    public void enqueue(Documento doc) {
        if (isEmpty()) {
            salida  = doc;
            entrada = doc;
        } else {
            entrada.siguiente = doc;
            entrada = doc;
        }
        tamanio++;
    }

    public Documento dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay documentos para imprimir.");
            return null;
        }
        Documento dato = salida;
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
        Documento actual = salida;
        while (actual != null) {
            System.out.print("Archivo:" + actual.nombreArchivo
                    + " Usuario:" + actual.usuario
                    + " Paginas:" + actual.numeroPaginas
                    + " Color:" + (actual.esColor ? "Si" : "No"));
            if (actual.siguiente != null)
                System.out.print(" > ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    public int calcularPaginasTotales() {
        int total = 0;
        Documento cursor = salida;
        while (cursor != null) {
            total  += cursor.numeroPaginas;
            cursor  = cursor.siguiente;
        }
        return total;
    }
}
