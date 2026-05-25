public class ColaUrgencias {
    private Paciente salida;  
    private Paciente entrada; 
    private int tamanio;

    public ColaUrgencias() {
        salida   = null;
        entrada  = null;
        tamanio  = 0;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public int size() {
        return tamanio;
    }

    public Paciente peek() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay paciente en espera.");
            return null;
        }
        return salida;
    }

    public void enqueue(Paciente paciente) {
        if (isEmpty()) {
            salida  = paciente;
            entrada = paciente;
        } else {
            entrada.siguiente = paciente;
            entrada = paciente;
        }
        tamanio++;
    }

    public Paciente dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía — no hay paciente para atender.");
            return null;
        }
        Paciente dato = salida;
        salida = salida.siguiente;
        if (salida == null) {
            entrada = null;
        }
        tamanio--;
        return dato;
    }

    public void imprimir() {
        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }
        System.out.print("Salida > ");
        Paciente actual = salida;
        while (actual != null) {
            System.out.print("Cedula:" + actual.cedula
                    + " Nombre:" + actual.nombreCompleto
                    + " Edad:" + actual.edad
                    + " (" + actual.sintomaPrincipal + ")");
            if (actual.siguiente != null)
                System.out.print(" > ");
            actual = actual.siguiente;
        }
        System.out.println(" < Entrada");
    }

    public void atenderTodos() {
        if (isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        System.out.println("\n--- INICIO DE ATENCIÓN ---");
        int totalAtendidos = 0;
        while (!isEmpty()) {
            Paciente p = dequeue();
            totalAtendidos++;
            System.out.println("Turno #" + totalAtendidos
                    + " | Cedula: " + p.cedula
                    + " | Nombre: " + p.nombreCompleto
                    + " | Edad: " + p.edad
                    + " | Sintoma: " + p.sintomaPrincipal);
        }
        System.out.println("--- FIN DEL TURNO ---");
        System.out.println("Total de pacientes atendidos: " + totalAtendidos);
    }
}
