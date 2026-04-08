package dosw.bitacora.corte2.semana1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio10 {

    public LinkedHashMap<String, Double> promedioAprobadosNaranjaOrdenado(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .filter(e -> "NARANJA".equals(e.getEquipo()))
                .flatMap(e -> e.getNotas().stream())
                .filter(Nota::isAprobada)
                .collect(Collectors.groupingBy(
                        Nota::getMateria,
                        Collectors.averagingDouble(Nota::getPuntaje)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
