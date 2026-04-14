public class Galeria {
    private Fotografia cabeza;
    private Fotografia cola;

    public Galeria(){
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarFoto(Fotografia nuevaFoto) {
        if (cabeza == null) {
            cabeza = nuevaFoto;
            cola = nuevaFoto;
        } else {
            cola.siguiente = nuevaFoto;
            nuevaFoto.anterior = cola;
            cola = nuevaFoto;
        }
    }

    public void siguienteFoto() {
        if (cabeza == null) {
            System.out.println("No hay fotos en la galería.");
            return;
        }
        if (cabeza.siguiente != null) {
            cabeza = cabeza.siguiente;
            System.out.println("Siguiente foto: " + cabeza);
        } else {
            System.out.println("Ya estás en la última foto de la galería.");
        }
    }

    public void fotoAnterior() {
        if (cabeza == null) {
            System.out.println("No hay fotos en la galería.");
            return;
        }
        if (cabeza.anterior != null) {
            cabeza = cabeza.anterior;
            System.out.println("Foto anterior: " + cabeza);
        } else {
            System.out.println("Ya estás en la primera foto de la galería.");
        }
    }

    public void reproducirGaleria() {
        if (cabeza == null) {
            System.out.println("No hay fotos en la galería para reproducir.");
            return;
        }
        System.out.println("Reproduciendo galería:");
        Fotografia actual = cabeza;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.siguiente;
        }
    }

}
