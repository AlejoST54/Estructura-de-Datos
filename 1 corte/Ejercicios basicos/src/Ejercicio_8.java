public class Ejercicio_8 {
//Ejercicio 8 — Historial de mensajes
//Un chat guarda el último mensaje enviado. Se usan dos variables String:

//ultimoMensaje = "Hola"
//copiaTexto = ultimoMensaje
//Luego copiaTexto se cambia a "¿Cómo estás?"
//Muestra ambas variables y explica en un comentario por qué ultimoMensaje no cambió (inmutabilidad de String).
public static void main(String[] args) {
    String ultimoMensaje = "Hola";
    String copiaTexto = ultimoMensaje;

    System.out.println("Último mensaje: " + ultimoMensaje);
    System.out.println("Copia de texto: " + copiaTexto);

    
    copiaTexto = "¿Cómo estás?";

    System.out.println("\nDespués de cambiar copiaTexto:");
    System.out.println("Último mensaje: " + ultimoMensaje); 
    System.out.println("Copia de texto: " + copiaTexto); 
}
}
