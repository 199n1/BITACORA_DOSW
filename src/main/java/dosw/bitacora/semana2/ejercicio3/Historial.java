package dosw.bitacora.semana2.ejercicio3;
import java.util.ArrayDeque;
import java.util.Deque;

public class Historial {
    private final Deque<EditorMemento> pila = new ArrayDeque<>();

    public void push(EditorMemento m) { pila.push(m); }

    public EditorMemento pop() {
        if (pila.isEmpty()) throw new IllegalStateException("Sin estados guardados");
        return pila.pop();
    }
    public boolean hayEstados() { return !pila.isEmpty(); }
}
