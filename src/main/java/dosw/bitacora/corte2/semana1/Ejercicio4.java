package dosw.bitacora.corte2.semana1;

import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio4 {

    public Map<String, Double> calcularPromedioPorMateria(Estudiante estudiante) {
        return estudiante.getNotas().stream()
                .collect(Collectors.groupingBy(
                        Nota::getMateria,
                        Collectors.averagingDouble(Nota::getPuntaje)
                ));
    }
}
