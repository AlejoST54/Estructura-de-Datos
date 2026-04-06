import java.util.Scanner;

public class App {
    //Monitoreo Industrial (Sensores en Tiempo Real)
//Una planta química registra lecturas de sus tanques cada hora en una lista enlazada para auditoría.

//La Clase Lectura (Nodo): Debe contener idSensor (int), temperatura (double), presion (double) y hora (String).
//El Problema: Las lecturas se van agregando al inicio para que la más reciente sea siempre la primera que vea el supervisor.
//Reto: Implementa un método que busque y muestre la lectura con la temperatura más alta registrada en el historial.
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        Lectura lect = new Lectura();

        do {
            System.out.println("\n==============================================");
            System.out.println("   PLANTA QUIMICA - Menú Principal");
            System.out.println("==============================================");
            System.out.println("1. Agregar nueva Lectura de Sensor");
            System.out.println("2. Mostrar Lectura con Temperatura más Alta");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el id del sensor: ");
                    sc.nextLine();
                    int idSensor = sc.nextInt();
                    System.out.print("Ingrese la temperatura: ");
                    double temperatura = sc.nextDouble();
                    System.out.print("Ingrese la presión: ");
                    double presion = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ingrese la hora: ");
                    String hora = sc.nextLine();

                    Lectura nuevaLectura = new Lectura(idSensor, temperatura, presion, hora);
                    lect.setSiguiente(nuevaLectura);
                    break;
                case 2:
                    double tempMax = Cola_Lectura.lecturaTemperaturaMaxima(lect);
                    System.out.println("La temperatura máxima registrada es: " + tempMax);
                    break;
                case 0:
                    System.out.println("¡Saliendo del módulo de Monitoreo!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
