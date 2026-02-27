package dosw.bitacora.semana2.ejercicio4;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora(List.of(
                new Suma(), new Resta(), new Multiplicacion(), new Division()
        ));

        double a = 10.5, b = 3.0;
        System.out.println("Operandos: " + a + " y " + b);

        calc.ejecutarTodas(a, b)
                .forEach((nombre, resultado) ->
                        System.out.printf("%s: %.2f%n", nombre, resultado));
    }
}
