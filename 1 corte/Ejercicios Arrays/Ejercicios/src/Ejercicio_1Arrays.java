public class Ejercicio_1Arrays {
//El Cajero del Supermercado (Inventario)
//Un cajero escanea un producto con el código de barras 770123. El sistema tiene un arreglo desordenado con los códigos de los productos disponibles en la estantería actual.

//El Problema: Debes recorrer la lista para verificar si el producto existe y en qué posición de la estantería se encuentra.
//Algoritmo a usar: Búsqueda Lineal. Es el ideal porque los productos en la estantería no tienen un orden numérico específico.
    public static void main(String[] args) {
        int[] codigosProductos = {770123, 770124, 770125, 770126, 770127};
        int codigoEscaneado = 770123;
        boolean encontrado = false;
        int posicion = -1;

        for (int i = 0; i < codigosProductos.length; i++) {
            if (codigosProductos[i] == codigoEscaneado) {
                encontrado = true;
                posicion = i;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Producto encontrado en la posicion: " + posicion);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

}
