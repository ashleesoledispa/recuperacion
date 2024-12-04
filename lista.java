public class lista {
    Nodo actual;

    public lista() {
        actual = null;
    }

    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (actual == null) {
            actual = nuevo;
            actual.siguiente = actual.anterior = actual;
        } else {
            Nodo temp = actual.anterior;
            temp.siguiente = nuevo;
            nuevo.anterior = temp;
            nuevo.siguiente = actual;
            actual.anterior = nuevo;
        }
    }

    public void eliminar(int valor) {
        if (actual == null) return;

        Nodo temp = actual;
        do {
            if (temp.valor == valor) {
                if (temp == actual && actual.siguiente == actual) {
                    actual = null;
                } else {
                    temp.anterior.siguiente = temp.siguiente;
                    temp.siguiente.anterior = temp.anterior;
                    if (temp == actual) actual = temp.siguiente;
                }
                break;
            }
            temp = temp.siguiente;
        } while (temp != actual);
    }

    public Nodo buscar(int valor) {
        if (actual == null) return null;

        Nodo temp = actual;
        do {
            if (temp.valor == valor) return temp;
            temp = temp.siguiente;
        } while (temp != actual);
        return null;
    }

    public void ordenar() {
        if (actual == null || actual.siguiente == actual) return;
        Nodo nodoOrdenado = actual.siguiente;

        while (nodoOrdenado != actual) {
            int key = nodoOrdenado.valor;
            Nodo temp = nodoOrdenado.anterior;

            while (temp != actual.anterior && temp.valor > key) {
                temp.siguiente.valor = temp.valor;
                temp = temp.anterior;
            }
            temp.siguiente.valor = key;
            nodoOrdenado = nodoOrdenado.siguiente;
        }
    }

    public String mostrar() {
        if (actual == null) return "Inventario vacío";
        StringBuilder sb = new StringBuilder();
        Nodo temp = actual;
        do {
            sb.append(temp.valor).append(" ");
            temp = temp.siguiente;
        } while (temp != actual);
        return sb.toString();
    }
}
