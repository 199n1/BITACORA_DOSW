package dosw.bitacora.corte2.semana1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio8 {

    public Map<String, List<Estudiante>> clasificarPorEstadoAcademico(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .collect(Collectors.groupingBy(e -> {
                    double promedio = e.getNotas().stream()
                            .mapToDouble(Nota::getPuntaje)
                            .average()
                            .orElse(0.0);
                    if (promedio >= 4.5) {
                        return "ALTO RENDIMIENTO";
                    } else if (promedio >= 3.5) {
                        return "REGULAR";
                    } else {
                        return "RIESGO";
                    }
                }));
    }
}
