public class Farmacia {
    private Medicamento tope;
    private int tamanio;

    public Farmacia() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamento.setSiguiente(tope);
        tope = medicamento;
        tamanio++;
    }

    public Medicamento retirarMedicamento() {
        if (estaVacia()) {
            System.out.println("No hay medicamentos en la farmacia.");
            return null;
        }
        Medicamento retirado = tope;
        tope = tope.getSiguiente();
        retirado.setSiguiente(null);
        tamanio--;
        return retirado;
    }

    public void validarDespacho() {
        while (tope != null && tope.getDiasParaVencer() < 10) {
            System.out.println("Retirando medicamento: " + tope.getNombre() + " que está a punto de vencer.");
            tope = tope.getSiguiente();
            tamanio--;
        }
        if (estaVacia()) {
            System.out.println("No hay medicamentos disponibles para despachar.");
        } else {
            System.out.println("El medicamento en el tope es seguro para despachar: " + tope.getNombre());
        }
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay medicamentos en la farmacia.");
            return;
        }
        Medicamento actual = tope;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.getSiguiente();
        }
    }
}
