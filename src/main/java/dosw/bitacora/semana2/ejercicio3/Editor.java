package dosw.bitacora.semana2.ejercicio3;

public class Editor {
    private String texto;

    public void setTexto(String texto)     { this.texto = texto; }
    public String getTexto()               { return texto; }
    public EditorMemento guardar()         { return new EditorMemento(texto); }
    public void restaurar(EditorMemento m) { this.texto = m.getEstado(); }
}
