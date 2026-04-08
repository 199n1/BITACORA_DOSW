package dosw.bitacora.corte2.semana1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio6 {

    public Map<String, Long> contarReprobadasPorEquipo(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .collect(Collectors.groupingBy(
                        Estudiante::getEquipo,
                        Collectors.summingLong(e ->
                                e.getNotas().stream()
                                        .filter(n -> !n.isAprobada())
                                        .count()
                        )
                ));
    }
}
