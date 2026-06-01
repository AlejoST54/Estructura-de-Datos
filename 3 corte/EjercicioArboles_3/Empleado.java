public class Empleado {
    long cedula;
    String nombreCompleto;
    String cargo;
    double salario;
    Empleado izquierdo;
    Empleado derecho;

    public Empleado(long cedula, String nombreCompleto, String cargo, double salario) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.salario = salario;
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "[Cédula: " + cedula + " | " + nombreCompleto + " | " + cargo + " | Salario: $" + salario + "]";
    }
}
