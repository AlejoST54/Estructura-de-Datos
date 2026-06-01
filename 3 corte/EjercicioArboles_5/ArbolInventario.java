public class ArbolInventario {
    private Repuesto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private Repuesto insertar(Repuesto nodo, int codigo, String descripcion, String marca, int stock) {
        if (nodo == null)
            return new Repuesto(codigo, descripcion, marca, stock);
        if (codigo < nodo.codigoRef)
            nodo.izquierdo = insertar(nodo.izquierdo, codigo, descripcion, marca, stock);
        else if (codigo > nodo.codigoRef)
            nodo.derecho = insertar(nodo.derecho, codigo, descripcion, marca, stock);
        else
            System.out.println("Ya existe un repuesto con código " + codigo + " — no se insertó.");
        return nodo;
    }

    public void insertar(int codigo, String descripcion, String marca, int stock) {
        raiz = insertar(raiz, codigo, descripcion, marca, stock);
    }

    private Repuesto buscar(Repuesto nodo, int codigo) {
        if (nodo == null) return null;
        if (codigo == nodo.codigoRef) return nodo;
        if (codigo < nodo.codigoRef)
            return buscar(nodo.izquierdo, codigo);
        else
            return buscar(nodo.derecho, codigo);
    }

    public Repuesto buscar(int codigo) {
        return buscar(raiz, codigo);
    }

    private void inOrden(Repuesto nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println("  " + nodo);
            inOrden(nodo.derecho);
        }
    }

    public void inOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  InOrden (código ascendente):");
        inOrden(raiz);
    }

    private int altura(Repuesto nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int altura() {
        return altura(raiz);
    }

    private int contarHojas(Repuesto nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private void backupPreOrden(Repuesto nodo) {
        if (nodo != null) {
            System.out.println("  " + nodo); 
            backupPreOrden(nodo.izquierdo);
            backupPreOrden(nodo.derecho);
        }
    }

    public void backupPreOrden() {
        if (isEmpty()) { System.out.println("  [ Árbol vacío ]"); return; }
        System.out.println("  Backup PreOrden (para reconstrucción del árbol):");
        backupPreOrden(raiz);
    }

    public void reporteRepuestosUnicos() {
        int unicos = contarHojas();
        System.out.println("  --- Reporte de Repuestos Únicos ---");
        System.out.println("  Repuestos sin variantes relacionadas (hojas): " + unicos);
        if (unicos == 1)
            System.out.println("  Hay 1 repuesto que no tiene variantes en el catálogo.");
        else
            System.out.println("  Hay " + unicos + " repuestos que no tienen variantes en el catálogo.");
    }
}
