public class Medicamento {
    private String nombre;
    private String lote;
    private int diasParaVencer;
    private Medicamento siguiente;

    public Medicamento(String nombre, String lote, int diasParaVencer) {
        this.nombre = nombre;
        this.lote = lote;
        this.diasParaVencer = diasParaVencer;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLote() {
        return lote;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public Medicamento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Medicamento siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nombre='" + nombre + '\'' +
                ", lote='" + lote + '\'' +
                ", diasParaVencer=" + diasParaVencer +
                '}';
    }

}
