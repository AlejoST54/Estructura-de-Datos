public class Ruta {
    private Estacion tope;
    private int tamanio;

    public Ruta() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarEstacion(Estacion estacion) {
        estacion.siguiente = tope;
        tope = estacion;
        tamanio++;
    }

    public Estacion retirarEstacion() {
        if (estaVacia()) {
            System.out.println("No hay estaciones en la ruta.");
            return null;
        }
        Estacion retirada = tope;
        tope = tope.siguiente;
        retirada.siguiente = null;
        tamanio--;
        return retirada;
    }

    public void retrocederASuperficie() {
        if (estaVacia()) {
            System.out.println("No hay estaciones registradas en la ruta.");
            return;
        }
        System.out.println("\n--- RETROCEDIENDO A LA SUPERFICIE ---");
        while (!estaVacia()) {
            Estacion actual = retirarEstacion();
            System.out.println("Pasando por: " + actual.getNombrePunto() +
                             " | Profundidad: " + actual.getProfundidad() + "m" +
                             " | Oxígeno: " + actual.getNivelOxigeno() + "%");
            if (actual.getNivelOxigeno() < 18.0) {
                System.out.println("ALERTA: Uso de Tanque de Emergencia Requerido en " + actual.getNombrePunto());
            }
        }
        System.out.println("Equipo en superficie.");
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay estaciones en la ruta.");
            return;
        }
        Estacion actual = tope;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.siguiente;
        }
    }
}
