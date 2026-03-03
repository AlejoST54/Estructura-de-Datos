import java.util.Scanner;
public class Reto_2 {
    //Un banco registra transacciones. tienes una lista de cuentas vip ordenada (10,25,40,80,150)
    //Entrada de datos: el usuario debe ingresar los montos y los numeros de cuenta de las ultimas 5 transacciones del cajero automatico
    //el reto
    //1 busca linealmennte cualquier transaccion cuyo monto supere los $5000
    //2 para cada cuenta que supere ese monto, verifica con busqueda binaria si pertenece a las cuentas vip. si no es vip, imprime: "Alerta de fraude"
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cuentasVIP = {10, 25, 40, 80, 150};
        int[] montosTransacciones = new int[5];
        int[] numerosCuenta = new int[5];

        for (int i= 0; i<5; i++){
            System.out.println("ingrese el monto de la transaccion");
            montosTransacciones[i] = sc.nextInt();
            System.out.println("ingrese el numero de cuenta");
            numerosCuenta[i] = sc.nextInt();
        }

        for (int i = 0; i < montosTransacciones.length; i++){
            if (montosTransacciones[i]>5000){
                int izquierda = 0;
                int derecha = cuentasVIP.length -1;
                boolean esVip = false;
                while (izquierda <= derecha){
                    int medio = izquierda + (derecha - izquierda) / 2;
                    if (cuentasVIP[medio] == numerosCuenta[i]){
                        esVip = true;
                        break;
                    } else if (cuentasVIP[medio] < numerosCuenta[i]){
                        izquierda = medio + 1;
                    } else {
                        derecha = medio - 1;
                    }
                }
                if (!esVip) {
                    System.out.println("la cuenta ingresada " + numerosCuenta[i] + " con monto " + montosTransacciones[i] + " es un caso de fraude");
                }
            }
        }  
    }
}
