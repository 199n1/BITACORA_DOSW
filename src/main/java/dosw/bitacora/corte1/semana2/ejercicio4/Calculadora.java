package dosw.bitacora.corte1.semana2.ejercicio4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculadora {
    private final List<Operacion> operaciones;

    public Calculadora(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    public Map<String, Double> ejecutarTodas(double a, double b) {
        return operaciones.stream()
                .peek(op -> System.out.println("Ejecutando: " + op.getNombre()))
                .collect(Collectors.toMap(
                        Operacion::getNombre,
                        op -> op.calcular(a, b)
                ));
    }
}
