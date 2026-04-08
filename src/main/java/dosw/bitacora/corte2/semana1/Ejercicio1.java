package dosw.bitacora.corte2.semana1;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {

    public List<Estudiante> obtenerEstudiantesNaranja(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .filter(e -> "NARANJA".equals(e.getEquipo()))
                .collect(Collectors.toList());
    }
}
