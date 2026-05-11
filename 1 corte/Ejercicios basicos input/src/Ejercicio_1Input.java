import java.util.Scanner;
public class Ejercicio_1Input {
//Ejercicio 1 — Recibo de compra
//Pide al usuario el nombre de un producto, la cantidad comprada y el precio unitario. Calcula el subtotal, aplica un IVA del 19% y muestra el recibo con el total a pagar.

//Datos de entrada:

//String nombre del producto
//int cantidad
//double precio unitario
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto:");
        String nombre_producto = sc.nextLine();
        System.out.println("Digite la cantidad del producto:");
        int cantidad_producto = sc.nextInt();
        System.out.println("¿Cuanto cuesta el producto?:");
        double precio_producto = sc.nextDouble();

        double subtotal = cantidad_producto*precio_producto;
        double IVA = 0.19*subtotal;
        double total =subtotal-IVA;

        System.out.println("*******Recibo********");
        System.out.println("Nombre del producto: "+ nombre_producto);
        System.out.println("Cantidad del producto: "+ cantidad_producto);
        System.out.println("c/u: "+ precio_producto);
        System.out.println("IVA 19%: "+ IVA);
        System.out.println("Subtotal: "+ subtotal);
        System.out.println("Total: "+ total);
    }
}
