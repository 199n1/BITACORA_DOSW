package dosw.bitacora.corte2.semana1;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {

    public List<String> obtenerNombresOrdenados(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .map(Estudiante::getNombre)
                .sorted()
                .collect(Collectors.toList());
    }
}
