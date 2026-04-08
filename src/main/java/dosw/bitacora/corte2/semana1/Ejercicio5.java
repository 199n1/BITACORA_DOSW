package dosw.bitacora.corte2.semana1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Ejercicio5 {

    public Estudiante obtenerMejorEstudiante(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .max(Comparator.comparingDouble(e ->
                        e.getNotas().stream()
                                .mapToDouble(Nota::getPuntaje)
                                .average()
                                .orElse(0.0)
                ))
                .orElseThrow(() -> new NoSuchElementException("No hay estudiantes registrados"));
    }
}
