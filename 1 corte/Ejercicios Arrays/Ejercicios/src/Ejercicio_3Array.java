public class Ejercicio_3Array {
//Sensor de Temperatura (Control de Calidad)
//Una máquina industrial registra la temperatura cada 10 minutos y guarda los datos en un arreglo.

//El Problema: Al final del día, el supervisor quiere saber cuál fue la temperatura más alta registrada para asegurarse de que la máquina no se recalentó.
//Algoritmo a usar: Búsqueda Lineal de Máximo. Debes recorrer todo el arreglo comparando cada valor para encontrar el mayor de todos.
    public static void main(String[] args) {
        double[] temperaturas = {25.5, 26.0, 27.3, 28.1, 29.0, 30.5, 31.2, 32.0};
        double maximaTemperatura = temperaturas[0];

        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > maximaTemperatura) {
                maximaTemperatura = temperaturas[i];
            }
        }

        System.out.println("La temperatura mas alta registrada fue: " + maximaTemperatura + "°C");
    }

}
