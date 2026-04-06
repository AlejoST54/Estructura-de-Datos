public class Vuelo {
    String numeroVuelo;
    String aerolinea;
    int combustible_restante;
    int pasajeros;
    Vuelo siguiente;

    public Vuelo(String numeroVuelo, String aerolinea, int combustible_restante, int pasajeros) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.combustible_restante = combustible_restante;
        this.pasajeros = pasajeros;
        this.siguiente = null;
    }

    public Vuelo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Vuelo siguiente) {
        this.siguiente = siguiente;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public int getCombustible_restante() {
        return combustible_restante;
    }

    public void setCombustible_restante(int combustible_restante) {
        this.combustible_restante = combustible_restante;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }
}
