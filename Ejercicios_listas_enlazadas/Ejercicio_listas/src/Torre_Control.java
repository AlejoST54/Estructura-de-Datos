public class Torre_Control {
//Simula la cola de aviones esperando para aterrizar en un aeropuerto congestionado.

//La Clase Vuelo (Nodo): Debe contener numeroVuelo (String), aerolinea (String), combustibleRestante (int) y pasajeros (int).
//El Problema: Normalmente los vuelos se forman al final de la cola. Sin embargo, si un vuelo reporta menos de 10 unidades de combustible, debe ser movido inmediatamente al inicio de la lista (Cabeza).
//Reto: Implementar el método reportarEmergencia(String numeroVuelo) que busque un vuelo en la cola y lo mueva al principio.
    public static Vuelo reportarEmergencia(String numeroVuelo, Vuelo cabeza) {
        if (cabeza == null) {
            return null;
        }

        if (cabeza.getNumeroVuelo().equals(numeroVuelo)) {
            return cabeza;
        }

        Vuelo actual = cabeza;
        Vuelo anterior = null;

        while (actual != null) {
            if (actual.getNumeroVuelo().equals(numeroVuelo)) {
                anterior.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(cabeza);
                return actual;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return cabeza;
    }

    public static void imprimirCola(Vuelo cabeza) {
        Vuelo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getNumeroVuelo() + " - " + actual.getAerolinea());
            actual = actual.getSiguiente();
        }
    }


    public static void main(String[] args) {

        Vuelo vuelo1 = new Vuelo("AA123", "American Airlines", 50, 150);
        Vuelo vuelo2 = new Vuelo("DL456", "Delta Airlines", 8, 200);
        Vuelo vuelo3 = new Vuelo("UA789", "United Airlines", 30, 180);


        vuelo1.setSiguiente(vuelo2);
        vuelo2.setSiguiente(vuelo3);
        Vuelo cabeza = vuelo1;


        System.out.println("=== Cola inicial ===");
        imprimirCola(cabeza);


        System.out.println("\n Emergencia reportada: DL456 (combustible: 8)");
        cabeza = reportarEmergencia("DL456", cabeza);

        System.out.println("\n=== Cola después de emergencia ===");
        imprimirCola(cabeza);

        
        System.out.println("\n Intentando reportar vuelo inexistente: XX999");
        cabeza = reportarEmergencia("XX999", cabeza);
        System.out.println("\n=== Cola sin cambios ===");
        imprimirCola(cabeza);
    }
}

