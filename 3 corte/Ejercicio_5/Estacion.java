public class Estacion {
    private String nombrePunto;
    private int profundidad;
    private double nivelOxigeno;
    public Estacion siguiente;

    public Estacion(String nombrePunto, int profundidad, double nivelOxigeno) {
        this.nombrePunto = nombrePunto;
        this.profundidad = profundidad;
        this.nivelOxigeno = nivelOxigeno;
        this.siguiente = null;
    }

    public String getNombrePunto() {
        return nombrePunto;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public double getNivelOxigeno() {
        return nivelOxigeno;
    }

    @Override
    public String toString() {
        return "Estacion [nombrePunto=" + nombrePunto + ", profundidad=" + profundidad + ", nivelOxigeno=" + nivelOxigeno + "]";
    }
}
