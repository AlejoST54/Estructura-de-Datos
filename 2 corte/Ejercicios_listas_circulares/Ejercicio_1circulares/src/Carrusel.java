public class Carrusel {
    Anuncio cabeza;
    Anuncio cola;

    public void agregarAnuncio(Anuncio anuncio) {
    
        if (cabeza == null) {
            cabeza = anuncio;
            cola = anuncio;
            anuncio.siguiente = cabeza; 
        } else {
            cola.siguiente = anuncio; 
            anuncio.siguiente = cabeza; 
            cola = anuncio; 
        }
    }

    public void mostrarAnuncios(){

        if (cabeza == null) {
            System.out.println("No hay anuncios registrados.");
            return;
        }

            Anuncio actual = cabeza;
        do {
            System.out.println("titulo: " + actual.titulo + ", Duracion: " + actual.duracionSegundos + ", Categoria: " + actual.categoria + "Veces repetido: " + actual.vecesRepetido);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void reproducir(int ciclos){
        if (cabeza == null) {
            System.out.println("No hay anuncios para reproducir.");
            return;
        }

        Anuncio actual = cabeza;
        int tiempoTotal = 0;

        for (int i = 0; i < ciclos; i++) {
            do {
                System.out.println("Reproduciendo anuncio: " + actual.titulo);
                actual.vecesRepetido++;
                tiempoTotal += actual.duracionSegundos;
                actual = actual.siguiente;
            } while (actual != cabeza);
        }

        Anuncio anuncioMasRepetido = cabeza;
        actual = cabeza.siguiente;

        do {
            if (actual.vecesRepetido > anuncioMasRepetido.vecesRepetido) {
                anuncioMasRepetido = actual;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("Anuncio más repetido: " + anuncioMasRepetido.titulo + " con " + anuncioMasRepetido.vecesRepetido + " repeticiones.");
        System.out.println("Tiempo total acumulado: " + tiempoTotal + " segundos.");

    }



}
