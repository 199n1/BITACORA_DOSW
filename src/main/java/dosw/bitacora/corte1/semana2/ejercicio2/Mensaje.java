package dosw.bitacora.corte1.semana2.ejercicio2;

public class Mensaje {
    private final String texto;
    private final String autor;
    private final String fecha;

    public Mensaje(String texto, String autor, String fecha) {
        this.texto = texto;
        this.autor = autor;
        this.fecha = fecha;
    }
    public String getTexto() { return texto; }
    public String getAutor() { return autor; }
    public String getFecha() { return fecha; }
}
