package dosw.bitacora.corte2.semana1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio9 {

    public String obtenerMateriaConMasReprobaciones(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .flatMap(e -> e.getNotas().stream())
                .filter(n -> !n.isAprobada())
                .collect(Collectors.groupingBy(Nota::getMateria, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Sin reprobaciones");
    }
}
