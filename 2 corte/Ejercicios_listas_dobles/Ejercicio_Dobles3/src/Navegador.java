public class Navegador {
    Pestana cabeza;
    Pestana cola;

    public void mostrarPestanas() {
        Pestana actual = cabeza;
        while (actual != null) {
            System.out.println("Pestaña: " + actual.tituloPagina + ", URL: " + actual.url + ", Hora de Apertura: " + actual.horaApertura);
            actual = actual.siguiente;
        }
    }
    public void cerrarPestanaActual(String url) {
        Pestana actual = cabeza;
        while (actual != null) {
            if (actual.url.equals(url)) {
                if (actual == cabeza) {
                    cabeza = actual.siguiente;
                    if (cabeza != null) {
                        cabeza.anterior = null;
                    }
                } else if (actual == cola) {
                    cola = actual.anterior;
                    if (cola != null) {
                        cola.siguiente = null;
                    }
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                System.out.println("Pestaña cerrada: " + url);
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Pestaña no encontrada: " + url);
    }


}
