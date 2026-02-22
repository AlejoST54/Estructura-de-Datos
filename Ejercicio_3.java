public class Ejercicio_3 {
    public static void main(String[] args) {
        
        double Temperatura_Celsius = 81.0;
        String Sensor = "DHT11";
        int numero_de_lecturas = 5;
        boolean alarma = false;

        if (Temperatura_Celsius>80){
            alarma = true;
        }
        System.out.println("**********Datos del sensor de temperatura*************" );
        System.out.println("Temperatura: " + Temperatura_Celsius);
        System.out.println("Sensor: " + Sensor);
        System.out.println("Numero de lecturas: " + numero_de_lecturas);
        System.out.println("Alarma activada: " + alarma);

    }

}
