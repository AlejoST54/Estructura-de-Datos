import java.util.Scanner;
public class Reto1 {
    //Crea un vector double[] precios = new double[5]
    //usa un ciclo for y Scanner para pedirle al usuario que ingrese los 5 precios uno por uno
    //TArea A Calcular la suma total de los precios ingresados
    //Tarea B encuentra cual fue el precio mas alto que se ingreso y muestralo
    //Tarea C si el total supera los 20000, muestra un mensaje: "tienes un descuento de 2000".Resta ese valor y muestra el total final a pagar
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        double[] precios = new double[5];
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Ingrese los precios:");
            precios[i] = sc.nextDouble();   
        }
        double suma = 0;
        for (int i = 0; i < precios.length; i++) {
            suma += precios[i];
        }
        System.out.println("La suma total de los precios es: " + suma);

        double precioMax = 0;
        for (int i = 0; i < precios.length; i++) {
            if (precios[i] > precioMax) {
                precioMax = precios[i];
            }
        }
        System.out.println("El precio mas alto es: " + precioMax);

        if (suma > 20000) {
            System.out.println("Tienes un descuento de 2000");
            suma -= 2000;
        }
        System.out.println("El total final a pagar es: " + suma);


    }
}
