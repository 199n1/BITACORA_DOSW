package dosw.bitacora.corte2.semana1;

import java.util.List;

public class Estudiante {

    private String id;
    private String nombre;
    private String equipo;
    private List<Nota> notas;

    public Estudiante() {}

    public Estudiante(String id, String nombre, String equipo, List<Nota> notas) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.notas = notas;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEquipo() { return equipo; }
    public void setEquipo(String equipo) { this.equipo = equipo; }

    public List<Nota> getNotas() { return notas; }
    public void setNotas(List<Nota> notas) { this.notas = notas; }

    @Override
    public String toString() {
        return "Estudiante{id='" + id + "', nombre='" + nombre + "', equipo='" + equipo + "'}";
    }
}
