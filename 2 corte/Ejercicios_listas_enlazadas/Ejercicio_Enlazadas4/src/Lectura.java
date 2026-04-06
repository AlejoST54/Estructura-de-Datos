public class Lectura {
    int idSensor;
    double temperatura;
    double presion;
    String hora;
    Lectura siguiente;

    public Lectura(){
        
    }

    public Lectura(int idSensor, double temperatura, double presion, String hora) {
        this.idSensor = idSensor;
        this.temperatura = temperatura;
        this.presion = presion;
        this.hora = hora;
        this.siguiente = null;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPresion() {
        return presion;
    }

    public void setPresion(double presion) {
        this.presion = presion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Lectura getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Lectura siguiente) {
        this.siguiente = siguiente;
    }
    

}
