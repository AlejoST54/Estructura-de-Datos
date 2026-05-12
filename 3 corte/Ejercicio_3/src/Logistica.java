public class Logistica {
    private Camion tope;
    private int tamanio;

    public Logistica() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarCamion(Camion camion) {
        camion.setSiguiente(tope);
        tope = camion;
        tamanio++;
    }

    public Camion retirarCamion() {
        if (estaVacia()) {
            System.out.println("No hay camiones en logística.");
            return null;
        }
        Camion camionRetirado = tope;
        tope = tope.getSiguiente();
        camionRetirado.setSiguiente(null);
        tamanio--;
        return camionRetirado;
    }

    public double calcularCargaTotal() {
        double cargaTotal = 0;
        Camion actual = tope;
        while (actual != null) {
            cargaTotal += actual.getCargaToneladas();
            actual = actual.getSiguiente();
        }
        return cargaTotal;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay camiones en logística.");
            return;
        }
        Camion actual = tope;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.getSiguiente();
        }
    }
}