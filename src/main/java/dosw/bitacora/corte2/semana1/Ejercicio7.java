package dosw.bitacora.corte2.semana1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio7 {

    public List<Estudiante> obtenerTop3Aprobados(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .sorted(Comparator.comparingLong((Estudiante e) ->
                        e.getNotas().stream()
                                .filter(Nota::isAprobada)
                                .count()
                ).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }
}
