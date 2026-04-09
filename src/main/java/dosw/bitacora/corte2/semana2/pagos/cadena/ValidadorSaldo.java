package dosw.bitacora.corte2.semana2.pagos.cadena;

public class ValidadorSaldo extends ManejadorValidacion {

    private final double saldoDisponible;

    public ValidadorSaldo(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public boolean validar(double monto) {
        System.out.println("[Validacion] Verificando saldo...");
        if (monto > saldoDisponible) {
            System.out.println("[RECHAZADO] Saldo insuficiente. Disponible: $" + saldoDisponible);
            return false;
        }
        System.out.println("[OK] Saldo suficiente");
        return pasarAlSiguiente(monto);
    }
}