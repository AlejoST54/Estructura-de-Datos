public class Ejercicio_6 {
//    Ejercicio 6 — Turno en un banco
//Un cajero de banco trabaja con el número del turno actual. Se crea una variable turnoActual
//  y se asigna a turnoEnPantalla.
//Demuestra con código que cambiar turnoEnPantalla no afecta a turnoActual (comportamiento por valor).
//Explica en un comentario por qué ocurre esto.

public static void main(String[] args) {
    int turnoActual = 5; 
    int turnoEnPantalla = turnoActual; 

    System.out.println("Turno actual: " + turnoActual);
    System.out.println("Turno en pantalla: " + turnoEnPantalla); 

    
    turnoEnPantalla = 10;

    System.out.println("Después de cambiar turnoEnPantalla:");
    System.out.println("Turno actual: " + turnoActual); 
    System.out.println("Turno en pantalla: " + turnoEnPantalla); 

}


}
