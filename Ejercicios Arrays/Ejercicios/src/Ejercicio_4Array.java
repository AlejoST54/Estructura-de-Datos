import java.util.Scanner;
public class Ejercicio_4Array {
//Control de Acceso (Gimnasio)
//Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. La lista está ordenada de menor a mayor.

//El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
//Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está organizada.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] codigosAcceso = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
        System.out.println("Ingrese su codigo de acceso:");
        int codigoIngresado = sc.nextInt();
        int izquierda = 0;
        int derecha = codigosAcceso.length - 1;
        boolean encontrado = false;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (codigosAcceso[medio] == codigoIngresado) {
                encontrado = true;
                break;
            } else if (codigosAcceso[medio] < codigoIngresado) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        if (encontrado) {
            System.out.println("Acceso permitido. Bienvenido al gimnasio.");
        } else {
            System.out.println("Acceso denegado. No ha pagado la mensualidad.");
        }
    
    }
}
