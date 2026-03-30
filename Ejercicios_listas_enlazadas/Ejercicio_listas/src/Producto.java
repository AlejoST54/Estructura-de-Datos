
public class Producto {
    String nombre;
    int cantidad;
    int dia_para_vencer;
    Producto siguiente;

    public Producto(String nombre, int cantidad, int dia_para_vencer) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.dia_para_vencer = dia_para_vencer;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getDiaParaVencer() {
        return dia_para_vencer;
    }

    public Producto getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
    }
    

}
