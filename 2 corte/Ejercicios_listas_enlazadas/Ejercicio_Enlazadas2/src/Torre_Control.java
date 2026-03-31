import java.util.Scanner;
//Torre de Control (Aterrizajes de Emergencia)
//Simula la cola de aviones esperando para aterrizar en un aeropuerto congestionado.

//La Clase Vuelo (Nodo): Debe contener numeroVuelo (String), aerolinea (String), combustibleRestante (int) y pasajeros (int).
//El Problema: Normalmente los vuelos se forman al final de la cola. Sin embargo, si un vuelo reporta menos de 10 unidades de combustible, debe ser movido inmediatamente al inicio de la lista (Cabeza).
//Reto: Implementar el método reportarEmergencia(String numeroVuelo) que busque un vuelo en la cola y lo mueva al principio.

public class Torre_Control {

    public static Vuelo reportarEmergencia(String numeroVuelo, Vuelo cabeza) {
        if (cabeza == null) return null;

        if (cabeza.getNumeroVuelo().equals(numeroVuelo)) return cabeza;

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
        int posicion = 1;
        while (actual != null) {
            System.out.println(posicion + ". " + actual.getNumeroVuelo()
                    + " - " + actual.getAerolinea()
                    + " | Combustible: " + actual.getCombustible_restante()
                    + " | Pasajeros: " + actual.getPasajeros());
            actual = actual.getSiguiente();
            posicion++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos vuelos desea registrar? ");
        int cantidad = Integer.parseInt(sc.nextLine().trim());

        Vuelo cabeza = null;
        Vuelo cola = null;

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\n--- Vuelo #" + i + " ---");

            System.out.print("Numero de vuelo: ");
            String numeroVuelo = sc.nextLine().trim();

            System.out.print("Aerolinea: ");
            String aerolinea = sc.nextLine().trim();

            System.out.print("Combustible restante: ");
            int combustible = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Pasajeros: ");
            int pasajeros = Integer.parseInt(sc.nextLine().trim());

            Vuelo nuevo = new Vuelo(numeroVuelo, aerolinea, combustible, pasajeros);

            if (combustible < 10) {
                System.out.println("Emergencia detectada: combustible critico. Vuelo movido al inicio.");
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;
                if (cola == null) cola = nuevo;
            } else {
                if (cabeza == null) {
                    cabeza = nuevo;
                    cola = nuevo;
                } else {
                    cola.setSiguiente(nuevo);
                    cola = nuevo;
                }
            }
        }

        System.out.println("\n=== Cola inicial ===");
        imprimirCola(cabeza);

        System.out.print("\nIngrese numero de vuelo para reportar emergencia (o 'no' para omitir): ");
        String respuesta = sc.nextLine().trim();

        if (!respuesta.equalsIgnoreCase("no")) {
            cabeza = reportarEmergencia(respuesta, cabeza);
            System.out.println("\n=== Cola despues de emergencia ===");
            imprimirCola(cabeza);
        }

        sc.close();
    }
}