public class ArbolNomina {
    private Empleado raiz;

    public ArbolNomina() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Empleado insertar(Empleado nodo, long cedula, String nombre, String cargo, double salario) {
        if (nodo == null)
            return new Empleado(cedula, nombre, cargo, salario);
        if (cedula < nodo.cedula)
            nodo.izquierdo = insertar(nodo.izquierdo, cedula, nombre, cargo, salario);
        else if (cedula > nodo.cedula)
            nodo.derecho = insertar(nodo.derecho, cedula, nombre, cargo, salario);
        else
            System.out.println("Ya existe un empleado con cédula " + cedula + " — no se insertó.");
        return nodo;
    }

    public void insertar(long cedula, String nombre, String cargo, double salario) {
        raiz = insertar(raiz, cedula, nombre, cargo, salario);
    }

    private Empleado buscar(Empleado nodo, long cedula) {
        if (nodo == null) return null;
        if (cedula == nodo.cedula) return nodo;
        if (cedula < nodo.cedula)
            return buscar(nodo.izquierdo, cedula);
        else
            return buscar(nodo.derecho, cedula);
    }

    public Empleado buscar(long cedula) {
        return buscar(raiz, cedula);
    }

    private void inOrden(Empleado nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println("  " + nodo);
            inOrden(nodo.derecho);
        }
    }

    public void inOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  InOrden (cédula ascendente):");
        inOrden(raiz);
    }

    private void preOrden(Empleado nodo) {
        if (nodo != null) {
            System.out.println("  " + nodo);
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void preOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  PreOrden (raíz primero):");
        preOrden(raiz);
    }

    private int altura(Empleado nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int altura() {
        return altura(raiz);
    }

    private int contarHojas(Empleado nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private Empleado buscarMinimo(Empleado nodo) {
        if (nodo == null) return null;
        if (nodo.izquierdo == null) return nodo;
        return buscarMinimo(nodo.izquierdo);
    }

    public void buscarMinimo() {
        Empleado min = buscarMinimo(raiz);
        if (min == null)
            System.out.println("  [ Árbol vacío ]");
        else
            System.out.println("  Empleado con menor cédula (más antiguo): " + min);
    }

    private Empleado buscarMaximo(Empleado nodo) {
        if (nodo == null) return null;
        if (nodo.derecho == null) return nodo; 
        return buscarMaximo(nodo.derecho);
    }

    public void buscarMaximo() {
        Empleado max = buscarMaximo(raiz);
        if (max == null)
            System.out.println("  [ Árbol vacío ]");
        else
            System.out.println("  Empleado con mayor cédula (más reciente): " + max);
    }

    public void reporteEficiencia() {
        System.out.println("  --- Reporte de eficiencia ---");
        System.out.println("  Altura del árbol : " + altura());
        System.out.println("  Nodos hoja       : " + contarHojas());
        System.out.println("  (Altura ideal para " + contarNodos(raiz) + " nodos: ~"
                + (int) Math.floor(Math.log(contarNodos(raiz) + 1) / Math.log(2)) + ")");
    }
    
    private int contarNodos(Empleado nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.izquierdo) + contarNodos(nodo.derecho);
    }
}
