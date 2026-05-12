public class Pieza {
    private String nombrePieza;
    private String numeroSerie;
    private boolean esDefectuosa;
    public Pieza siguiente;

    public Pieza() {
    }

    public Pieza(String nombrePieza, String numeroSerie, boolean esDefectuosa) {
        this.nombrePieza = nombrePieza;
        this.numeroSerie = numeroSerie;
        this.esDefectuosa = esDefectuosa;
        this.siguiente = null;
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public boolean isEsDefectuosa() {
        return esDefectuosa;
    }

    @Override
    public String toString() {
        return "Pieza [nombrePieza=" + nombrePieza + ", numeroSerie=" + numeroSerie + ", esDefectuosa=" + esDefectuosa + "]";
    }
}
