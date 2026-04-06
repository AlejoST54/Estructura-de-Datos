public class Fila_Reproduccion {
        public static void agregarCancion(cancion cabeza, cancion nueva) {
            if (cabeza == null) {
            } else {
                cancion actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nueva);
            }
        }

        public static void agregarCancionAlFinal(cancion cabeza, cancion nueva) {
            if (cabeza == null) {
                System.out.println("Cancion agregada al final: " + nueva.getTitulo());
            } else {
                cancion actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nueva);
                System.out.println("Cancion agregada al final: " + nueva.getTitulo()); 
            }
        }

        public static int duracionTotal(cancion cabeza) {
            int duracionTotal = 0;
            cancion actual = cabeza;
            while (actual != null) {
                duracionTotal += actual.getDuracionSegundos();
                actual = actual.getSiguiente();
            }
            return duracionTotal;
        }

        public static void imprimirLista(cancion cabeza) {
            cancion actual = cabeza;
            int posicion = 1;
            while (actual != null) {
                System.out.println(posicion + ". " + actual.getTitulo()
                        + " - " + actual.getArtista()
                        + " | Duración: " + actual.getDuracionSegundos() + " seg"
                        + " | Género: " + actual.getGenero());
                actual = actual.getSiguiente();
                posicion++;
            }
        }



}
