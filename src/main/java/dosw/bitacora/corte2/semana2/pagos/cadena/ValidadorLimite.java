package dosw.bitacora.corte2.semana2.pagos.cadena;

public class ValidadorLimite extends ManejadorValidacion {

    private final double limiteTransaccion;

    public ValidadorLimite(double limiteTransaccion) {
        this.limiteTransaccion = limiteTransaccion;
    }

    @Override
    public boolean validar(double monto) {
        System.out.println("[Validacion] Verificando limite de transaccion...");
        if (monto > limiteTransaccion) {
            System.out.println("[RECHAZADO] Excede el limite de $" + limiteTransaccion);
            return false;
        }
        System.out.println("[OK] Dentro del limite");
        return pasarAlSiguiente(monto);
    }
}