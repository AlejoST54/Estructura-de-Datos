public class Cola_Lectura {
    public void agregarLectura(Lectura cabeza, Lectura nueva) {
        if (cabeza == null) {
        } else {
            Lectura actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nueva);
        }
    }

    public static double lecturaTemperaturaMaxima(Lectura cabeza) {
        if (cabeza == null) {
            System.out.println("No hay lecturas disponibles.");

        }
        Lectura lecturaMax = cabeza;
        Lectura actual = cabeza.getSiguiente();
        while (actual != null) {
            if (actual.getTemperatura() > lecturaMax.getTemperatura()) {
                lecturaMax = actual;
            }
            actual = actual.getSiguiente();
        }
        return lecturaMax.getTemperatura();
    }

}
