public class Galeria {
    private Fotografia cabeza;
    private Fotografia cola;

    public Galeria(){
        this.cabeza = null;
        this.cola = null;
    }

    public void reproducirGaleria(){
        Fotografia actual = cabeza;
        System.out.println("Reproduciendo galería hacia adelante:");
        while (actual != null) {
            System.out.println("Foto: " + actual + ", Tamaño: " + actual+ "MB, Resolución: " + actual);
            actual = actual.siguiente;
        }

        System.out.println("Reproduciendo galería hacia atrás:");
        actual = cola;
        while (actual != null) {
            System.out.println("Foto: " + actual + ", Tamaño: " + actual + "MB, Resolución: " + actual);
            actual = actual.anterior;
        }
    }
    



}
