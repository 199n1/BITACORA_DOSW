package dosw.bitacora.corte2.semana1;

import java.time.LocalDate;

public class Nota {

    private String materia;
    private double puntaje;
    private LocalDate fecha;
    private boolean aprobada;

    public Nota() {}

    public Nota(String materia, double puntaje, LocalDate fecha, boolean aprobada) {
        this.materia = materia;
        this.puntaje = puntaje;
        this.fecha = fecha;
        this.aprobada = aprobada;
    }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public double getPuntaje() { return puntaje; }
    public void setPuntaje(double puntaje) { this.puntaje = puntaje; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public boolean isAprobada() { return aprobada; }
    public void setAprobada(boolean aprobada) { this.aprobada = aprobada; }

    @Override
    public String toString() {
        return "Nota{materia='" + materia + "', puntaje=" + puntaje + ", aprobada=" + aprobada + "}";
    }
}
