public class Ejercicio_7 {
//    Ejercicio 7 — Inventario compartido
//Un almacén tiene un arreglo con el stock de 5 productos. 
//El sistema de ventas y el sistema de reportes apuntan al mismo arreglo.
//Crea el arreglo stockAlmacen con valores iniciales.
//Asigna stockReportes = stockAlmacen.
//Simula una venta reduciendo el stock de un producto desde stockReportes.
//Muestra que stockAlmacen también cambió y explica en comentarios por qué.
public static void main(String[] args) {
    int[] stockAlmacen = {100, 200, 150, 80, 50}; 
    int[] stockReportes = stockAlmacen; 

    System.out.println("Stock en el almacén:");
    for (int i = 0; i < stockAlmacen.length; i++) {
        System.out.println("Producto " + (i + 1) + ": " + stockAlmacen[i]);
    }

    
    stockReportes[2] -= 20; 

    System.out.println("\nDespués de simular una venta (reduciendo el stock del producto 3):");
    System.out.println("Stock en el almacén:");
    for (int i = 0; i < stockAlmacen.length; i++) {
        System.out.println("Producto " + (i + 1) + ": " + stockAlmacen[i]);
    }
}

}
