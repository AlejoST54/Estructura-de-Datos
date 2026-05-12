public class Camion {
    private String placa;
    private String conductor;
    private double cargaToneladas;
    private Camion siguiente; // Para la estructura de pila

    public Camion(String placa, String conductor, double cargaToneladas) {
        this.placa = placa;
        this.conductor = conductor;
        this.cargaToneladas = cargaToneladas;
        this.siguiente = null;
    }

    public String getPlaca() {
        return placa;
    }

    public String getConductor() {
        return conductor;
    }

    public double getCargaToneladas() {
        return cargaToneladas;
    }
    public Camion getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Camion siguiente) {
        this.siguiente = siguiente;
    }
    @Override
    public String toString() {
        return "Camion{" +
                "placa='" + placa + '\'' +
                ", conductor='" + conductor + '\'' +
                ", cargaToneladas=" + cargaToneladas +
                '}';
    }

}
