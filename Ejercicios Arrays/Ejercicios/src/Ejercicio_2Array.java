public class Ejercicio_2Array {
//Buscador de Cédulas (Base de Datos Bancaria)
//Un banco tiene una lista de 1.000 clientes organizados de forma estricta y ascendente por su número de cédula o ID.
//
//El Problema: Un cliente llega a la ventanilla y da su número. El sistema debe encontrar sus datos de la manera más rápida posible (en pocos pasos).
//Algoritmo a usar: Búsqueda Binaria. Como los datos ya están ordenados, este algoritmo permitirá encontrar al cliente dividiendo la lista a la mitad en cada paso.
    public static void main(String[] args) {
        int[] cedulasClientes = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010};
        int cedulaBuscada = 1005;
        int izquierda = 0;
        int derecha = cedulasClientes.length - 1;
        boolean encontrado = false;
        int posicion = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (cedulasClientes[medio] == cedulaBuscada) {
                encontrado = true;
                posicion = medio;
                break;
            } else if (cedulasClientes[medio] < cedulaBuscada) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        if (encontrado) {
            System.out.println("Cliente encontrado en la posicion: " + posicion);
        } else {
            System.out.println("Cliente no encontrado.");
        }
        
    }

}
