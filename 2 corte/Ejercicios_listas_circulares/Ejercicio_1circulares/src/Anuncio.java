public class Anuncio {
    String titulo;
    int duracionSegundos;
    int vecesRepetido;
    String categoria;
    Anuncio siguiente;

    public Anuncio(String titulo, int duracionSegundos, String categoria) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
        this.vecesRepetido = 0; 
        this.categoria = categoria;
        this.siguiente = null;
    }

}
