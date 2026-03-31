public class Inventario_de_alimentos extends Producto {

    public Inventario_de_alimentos(String nombre, int cantidad, int dia_para_vencer) {
        super(nombre, cantidad, dia_para_vencer); 
    }

    public static Producto verificaProducto(Producto nuevo, Producto cabeza) {
        if (cabeza == null || nuevo.getDiaParaVencer() < 3) {
            nuevo.setSiguiente(cabeza);
            return nuevo;
        } else {
            Producto actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            return cabeza;
        }
    }

    public static void main(String[] args) {
        Inventario_de_alimentos leche = new Inventario_de_alimentos("Leche", 10, 2);
        Inventario_de_alimentos yogurt = new Inventario_de_alimentos("Yogurt", 20, 5);
        Inventario_de_alimentos queso = new Inventario_de_alimentos("Queso", 15, 1);

        Producto cabeza = null;
        cabeza = verificaProducto(leche, cabeza);
        cabeza = verificaProducto(yogurt, cabeza);
        cabeza = verificaProducto(queso, cabeza);

        Producto actual = cabeza;
        while (actual != null) {
            if (actual.getDiaParaVencer() < 5) {
                System.out.println(actual.getNombre() + " - Cantidad: " + actual.getCantidad() + " - Días para vencer: " + actual.getDiaParaVencer());
            }
            actual = actual.getSiguiente();
        }
    }
}