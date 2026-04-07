package dosw.bitacora.corte1.semana2.ejercicio4;

public class Division implements Operacion {
    public double calcular(double a, double b) {
        if (b == 0) throw new ArithmeticException("División por cero");
        return a / b;
    }
    public String getNombre() { return "División"; }
}
