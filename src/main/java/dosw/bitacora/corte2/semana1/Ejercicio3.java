package dosw.bitacora.corte2.semana1;

import java.util.List;

public class Ejercicio3 {

    public double calcularPromedioGeneral(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .flatMap(e -> e.getNotas().stream())
                .mapToDouble(Nota::getPuntaje)
                .average()
                .orElse(0.0);
    }
}
